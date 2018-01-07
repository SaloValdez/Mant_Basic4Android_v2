package b4a.example;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class listar extends Activity implements B4AActivity{
	public static listar mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.listar");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (listar).");
				p.finish();
			}
		}
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.listar");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.listar", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (listar) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (listar) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return listar.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (listar) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (listar) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static class _renglones{
public boolean IsInitialized;
public String Renglon1;
public String Renglon2;
public String Renglon3;
public String Renglon4;
public String Renglon5;
public void Initialize() {
IsInitialized = true;
Renglon1 = "";
Renglon2 = "";
Renglon3 = "";
Renglon4 = "";
Renglon5 = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.http.HttpClientWrapper _hc = null;
public static int _paises = 0;
public static int _poblacion = 0;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnprincipal = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btninsertar = null;
public b4a.example.main _main = null;
public b4a.example.insertar _insertar = null;
public b4a.example.eliminar _eliminar = null;
public b4a.example.actualizar _actualizar = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="hc.Initialize(\"hc\")";
_hc.Initialize("hc");
 };
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Buscar_lista_de_paises";
_buscar_lista_de_paises();
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="Activity.LoadLayout(\"lay_listar\")";
mostCurrent._activity.LoadLayout("lay_listar",mostCurrent.activityBA);
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="End Sub";
return "";
}
public static String  _buscar_lista_de_paises() throws Exception{
RDebugUtils.currentModule="listar";
anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper _req = null;
String _query = "";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Buscar_lista_de_paises";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="ProgressDialogShow(\"Buscando lista de países.\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,"Buscando lista de países.");
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Dim req As HttpRequest";
_req = new anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper();
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Dim Query As String";
_query = "";
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Query=\"SELECT id,nombre,apellido,direccion,telefono FROM usuario ORDER BY id\"";
_query = "SELECT id,nombre,apellido,direccion,telefono FROM usuario ORDER BY id";
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
_req.InitializePost2("http://192.168.241.2:81/paises.php",_query.getBytes("UTF8"));
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="hc.Execute(req, paises) '''''''' En ResponseSuccess hará el Case de paises";
_hc.Execute(processBA,_req,_paises);
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public static String  _btnactualizar_click() throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub btnActualizar_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="StartActivity(\"Actualizar\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Actualizar"));
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
public static String  _btninsertar_click() throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub btnInsertar_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="StartActivity(\"insertar\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("insertar"));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="End Sub";
return "";
}
public static String  _btnireliminar_click() throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub btnIrEliminar_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="StartActivity(\"eliminar\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("eliminar"));
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="End Sub";
return "";
}
public static String  _btnprincipal_click() throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub btnPrincipal_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Main"));
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4a.http.HttpClientWrapper.HttpResponeWrapper _response,String _reason,int _statuscode,int _tarea) throws Exception{
RDebugUtils.currentModule="listar";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Log(\"Error: \" & Reason & \", StatusCode: \" & StatusCode)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_reason+", StatusCode: "+BA.NumberToString(_statuscode));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If Response <> Null Then";
if (_response!= null) { 
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
anywheresoftware.b4a.keywords.Common.Log(_response.GetString("UTF8"));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Response.Release";
_response.Release();
 };
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4a.http.HttpClientWrapper.HttpResponeWrapper _response,int _tarea) throws Exception{
RDebugUtils.currentModule="listar";
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _countries = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
b4a.example.listar._renglones _renglon = null;
anywheresoftware.b4a.objects.collections.List _l = null;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="res = Response.GetString(\"UTF8\")";
_res = _response.GetString("UTF8");
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Log(\"Respuesta del servidor: \" & res)";
anywheresoftware.b4a.keywords.Common.Log("Respuesta del servidor: "+_res);
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="Select tarea";
switch (BA.switchObjectToInt(_tarea,_paises,_poblacion)) {
case 0:
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="Dim countries As List";
_countries = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="countries.Initialize";
_countries.Initialize();
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="countries = parser.NextArray";
_countries = _parser.NextArray();
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="For i = 0 To countries.Size - 1";
{
final int step38 = 1;
final int limit38 = (int) (_countries.getSize()-1);
for (_i = (int) (0); (step38 > 0 && _i <= limit38) || (step38 < 0 && _i >= limit38); _i = ((int)(0 + _i + step38))) {
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="m = countries.Get(i)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_countries.Get(_i)));
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="Dim Renglon As Renglones";
_renglon = new b4a.example.listar._renglones();
RDebugUtils.currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="Renglon.Renglon1 = m.Get(\"id\")      ' ES";
_renglon.Renglon1 = BA.ObjectToString(_m.Get((Object)("id")));
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="Renglon.Renglon2 = m.Get(\"nombre\")  ' España";
_renglon.Renglon2 = BA.ObjectToString(_m.Get((Object)("nombre")));
RDebugUtils.currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="Renglon.Renglon3 = m.Get(\"apellido\")  ' España";
_renglon.Renglon3 = BA.ObjectToString(_m.Get((Object)("apellido")));
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="Renglon.Renglon4 = m.Get(\"direccion\")  ' España";
_renglon.Renglon4 = BA.ObjectToString(_m.Get((Object)("direccion")));
RDebugUtils.currentLine=655384;
 //BA.debugLineNum = 655384;BA.debugLine="Renglon.Renglon5 = m.Get(\"telefono\")  ' España";
_renglon.Renglon5 = BA.ObjectToString(_m.Get((Object)("telefono")));
RDebugUtils.currentLine=655385;
 //BA.debugLineNum = 655385;BA.debugLine="ListView1.AddTwoLines2(Renglon.Renglon1,Renglon.Renglon2 & \"  \"  & Renglon.Renglon3  & \" / \" &  Renglon.Renglon4 & \" / \" &  Renglon.Renglon5, Renglon)";
mostCurrent._listview1.AddTwoLines2(_renglon.Renglon1,_renglon.Renglon2+"  "+_renglon.Renglon3+" / "+_renglon.Renglon4+" / "+_renglon.Renglon5,(Object)(_renglon));
RDebugUtils.currentLine=655388;
 //BA.debugLineNum = 655388;BA.debugLine="ListView1.TwoLinesLayout.Label.TextColor = Colors.Green 'color del primer item";
mostCurrent._listview1.getTwoLinesLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=655389;
 //BA.debugLineNum = 655389;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.TextColor = Colors.white 'color del segundo item";
mostCurrent._listview1.getTwoLinesLayout().SecondLabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=655391;
 //BA.debugLineNum = 655391;BA.debugLine="ListView1.TwoLinesLayout.Label.TextSize = 10 'tamaño letra";
mostCurrent._listview1.getTwoLinesLayout().Label.setTextSize((float) (10));
RDebugUtils.currentLine=655392;
 //BA.debugLineNum = 655392;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.TextSize = 12 'tamaño letra";
mostCurrent._listview1.getTwoLinesLayout().SecondLabel.setTextSize((float) (12));
 }
};
RDebugUtils.currentLine=655395;
 //BA.debugLineNum = 655395;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break;
case 1:
RDebugUtils.currentLine=655399;
 //BA.debugLineNum = 655399;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=655400;
 //BA.debugLineNum = 655400;BA.debugLine="l = parser.NextArray";
_l = _parser.NextArray();
RDebugUtils.currentLine=655401;
 //BA.debugLineNum = 655401;BA.debugLine="If l.Size = 0 Then";
if (_l.getSize()==0) { 
 }else {
RDebugUtils.currentLine=655404;
 //BA.debugLineNum = 655404;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=655405;
 //BA.debugLineNum = 655405;BA.debugLine="m = l.Get(0)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_l.Get((int) (0))));
 };
 break;
}
;
RDebugUtils.currentLine=655409;
 //BA.debugLineNum = 655409;BA.debugLine="Response.Release";
_response.Release();
RDebugUtils.currentLine=655410;
 //BA.debugLineNum = 655410;BA.debugLine="End Sub";
return "";
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="listar";
b4a.example.listar._renglones _renglon = null;
anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper _req = null;
String _query = "";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As Object)";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="If IsBackgroundTaskRunning(hc, poblacion) Then ' Está ocupado en llamada anterior.";
if (anywheresoftware.b4a.keywords.Common.IsBackgroundTaskRunning(mostCurrent.activityBA,(Object)(_hc),_poblacion)) { 
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="ToastMessageShow(\"Espera hasta completar la llamada anterior.\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Espera hasta completar la llamada anterior.",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="Dim Renglon As Renglones";
_renglon = new b4a.example.listar._renglones();
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Renglon = Value";
_renglon = (b4a.example.listar._renglones)(_value);
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="Dim req As HttpRequest";
_req = new anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper();
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="Dim Query As String";
_query = "";
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="Query=\"SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE ID='\" & Renglon.Renglon1 & \"'\"";
_query = "SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE ID='"+_renglon.Renglon1+"'";
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
_req.InitializePost2("http://192.168.241.2:81/paises.php",_query.getBytes("UTF8"));
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="hc.Execute(req, poblacion)  '''''''' En ResponseSuccess hará el Case de poblacion";
_hc.Execute(processBA,_req,_poblacion);
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="Msgbox(\"Nombre :  \" & Renglon.Renglon2&  Chr(13) & Chr(10)  &\"Apellidos :  \" &  Renglon.Renglon3 &  Chr(13) & Chr(10)  &\"Direccion :  \" &  Renglon.Renglon4&  Chr(13) & Chr(10)  &\"Telefono :  \" &  Renglon.Renglon5, \"Detalles del Usuario\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Nombre :  "+_renglon.Renglon2+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)))+"Apellidos :  "+_renglon.Renglon3+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)))+"Direccion :  "+_renglon.Renglon4+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)))+"Telefono :  "+_renglon.Renglon5,"Detalles del Usuario",mostCurrent.activityBA);
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="End Sub";
return "";
}
}