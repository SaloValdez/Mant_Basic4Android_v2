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

public class eliminar extends Activity implements B4AActivity{
	public static eliminar mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.eliminar");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (eliminar).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.eliminar");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.eliminar", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (eliminar) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (eliminar) Resume **");
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
		return eliminar.class;
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
        BA.LogInfo("** Activity (eliminar) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (eliminar) Resume **");
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
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.http.HttpClientWrapper _hc = null;
public static int _paises = 0;
public static int _poblacion = 0;
public static int _bus = 0;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public static String _borraid = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btnbuscar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtbuscar = null;
public anywheresoftware.b4a.objects.LabelWrapper _txtid = null;
public anywheresoftware.b4a.objects.LabelWrapper _txtnombres = null;
public b4a.example.main _main = null;
public b4a.example.listar _listar = null;
public b4a.example.insertar _insertar = null;
public b4a.example.actualizar _actualizar = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="eliminar";
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="hc.Initialize(\"hc\")";
_hc.Initialize("hc");
 };
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="Activity.LoadLayout(\"lay_eliminar\")";
mostCurrent._activity.LoadLayout("lay_eliminar",mostCurrent.activityBA);
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="Buscar_lista_de_paises";
_buscar_lista_de_paises();
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="End Sub";
return "";
}
public static String  _buscar_lista_de_paises() throws Exception{
RDebugUtils.currentModule="eliminar";
anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper _req = null;
String _query = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Buscar_lista_de_paises";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="ProgressDialogShow(\"Buscando lista de países.\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,"Buscando lista de países.");
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Dim req As HttpRequest";
_req = new anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="Dim Query As String";
_query = "";
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="Query=\"SELECT nombre,apellido,direccion,telefono, id FROM usuario ORDER BY ID\"";
_query = "SELECT nombre,apellido,direccion,telefono, id FROM usuario ORDER BY ID";
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
_req.InitializePost2("http://192.168.241.2:81/paises.php",_query.getBytes("UTF8"));
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="hc.Execute(req, paises) '''''''' En ResponseSuccess hará el Case de paises";
_hc.Execute(processBA,_req,_paises);
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="End Sub";
return "";
}
public static String  _btnbuscar_click() throws Exception{
RDebugUtils.currentModule="eliminar";
anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper _req = null;
String _query = "";
String _busca = "";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub btnBuscar_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Dim req As HttpRequest";
_req = new anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Dim Query As String";
_query = "";
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Dim busca As String";
_busca = "";
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="busca = txtBuscar.Text";
_busca = mostCurrent._txtbuscar.getText();
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="Query=\"SELECT * FROM usuario WHERE nombre LIKE '\" & busca & \"'\"";
_query = "SELECT * FROM usuario WHERE nombre LIKE '"+_busca+"'";
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
_req.InitializePost2("http://192.168.241.2:81/paises.php",_query.getBytes("UTF8"));
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="hc.Execute(req, bus)";
_hc.Execute(processBA,_req,_bus);
RDebugUtils.currentLine=2359306;
 //BA.debugLineNum = 2359306;BA.debugLine="End Sub";
return "";
}
public static String  _btneliminar_click() throws Exception{
RDebugUtils.currentModule="eliminar";
anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper _req = null;
String _query = "";
String _ids = "";
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub btnEliminar_Click";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim req As HttpRequest";
_req = new anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper();
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Dim Query As String";
_query = "";
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Dim ids As String";
_ids = "";
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="ids = txtId.Text";
_ids = mostCurrent._txtid.getText();
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="Query=\"DELETE FROM usuario  WHERE id='\" & ids & \"'\"";
_query = "DELETE FROM usuario  WHERE id='"+_ids+"'";
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
_req.InitializePost2("http://192.168.241.2:81/paises.php",_query.getBytes("UTF8"));
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="hc.Execute(req, 4) ' ------- He cambiado esto, 4 es una tarea que no existe en Select";
_hc.Execute(processBA,_req,(int) (4));
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="ListView1.Clear";
mostCurrent._listview1.Clear();
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="Buscar_lista_de_paises";
_buscar_lista_de_paises();
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="txtId.Text=\"\"";
mostCurrent._txtid.setText((Object)(""));
RDebugUtils.currentLine=2293777;
 //BA.debugLineNum = 2293777;BA.debugLine="txtNombres.Text=\"\"";
mostCurrent._txtnombres.setText((Object)(""));
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="End Sub";
return "";
}
public static String  _btnirlistar_click() throws Exception{
RDebugUtils.currentModule="eliminar";
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub btnIrListar_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="StartActivity(\"listar\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("listar"));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4a.http.HttpClientWrapper.HttpResponeWrapper _response,String _reason,int _statuscode,int _tarea) throws Exception{
RDebugUtils.currentModule="eliminar";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Log(\"Error: \" & Reason & \", StatusCode: \" & StatusCode)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_reason+", StatusCode: "+BA.NumberToString(_statuscode));
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="If Response <> Null Then";
if (_response!= null) { 
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
anywheresoftware.b4a.keywords.Common.Log(_response.GetString("UTF8"));
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="Response.Release";
_response.Release();
 };
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4a.http.HttpClientWrapper.HttpResponeWrapper _response,int _tarea) throws Exception{
RDebugUtils.currentModule="eliminar";
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _countries = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
b4a.example.listar._renglones _renglon = null;
anywheresoftware.b4a.objects.collections.List _l = null;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="res = Response.GetString(\"UTF8\")";
_res = _response.GetString("UTF8");
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="Log(\"Respuesta del servidor: \" & res)";
anywheresoftware.b4a.keywords.Common.Log("Respuesta del servidor: "+_res);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="Select tarea";
switch (BA.switchObjectToInt(_tarea,_paises,_poblacion,_bus)) {
case 0:
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="Dim countries As List";
_countries = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="countries.Initialize";
_countries.Initialize();
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="countries = parser.NextArray";
_countries = _parser.NextArray();
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="For i = 0 To countries.Size - 1";
{
final int step42 = 1;
final int limit42 = (int) (_countries.getSize()-1);
for (_i = (int) (0); (step42 > 0 && _i <= limit42) || (step42 < 0 && _i >= limit42); _i = ((int)(0 + _i + step42))) {
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2097170;
 //BA.debugLineNum = 2097170;BA.debugLine="m = countries.Get(i)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_countries.Get(_i)));
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="Dim Renglon As Renglones";
_renglon = new b4a.example.listar._renglones();
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="Renglon.Renglon1 = m.Get(\"id\")      ' ES";
_renglon.Renglon1 = BA.ObjectToString(_m.Get((Object)("id")));
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="Renglon.Renglon2 = m.Get(\"nombre\")  ' España";
_renglon.Renglon2 = BA.ObjectToString(_m.Get((Object)("nombre")));
RDebugUtils.currentLine=2097174;
 //BA.debugLineNum = 2097174;BA.debugLine="Renglon.Renglon3 = m.Get(\"apellido\")  ' España";
_renglon.Renglon3 = BA.ObjectToString(_m.Get((Object)("apellido")));
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="Renglon.Renglon4 = m.Get(\"direccion\")  ' España";
_renglon.Renglon4 = BA.ObjectToString(_m.Get((Object)("direccion")));
RDebugUtils.currentLine=2097176;
 //BA.debugLineNum = 2097176;BA.debugLine="Renglon.Renglon5 = m.Get(\"telefono\")  ' España";
_renglon.Renglon5 = BA.ObjectToString(_m.Get((Object)("telefono")));
RDebugUtils.currentLine=2097177;
 //BA.debugLineNum = 2097177;BA.debugLine="ListView1.AddTwoLines2(Renglon.Renglon1, Renglon.Renglon2 & \"   \" &  Renglon.Renglon3 , Renglon)";
mostCurrent._listview1.AddTwoLines2(_renglon.Renglon1,_renglon.Renglon2+"   "+_renglon.Renglon3,(Object)(_renglon));
 }
};
RDebugUtils.currentLine=2097179;
 //BA.debugLineNum = 2097179;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break;
case 1:
RDebugUtils.currentLine=2097183;
 //BA.debugLineNum = 2097183;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2097184;
 //BA.debugLineNum = 2097184;BA.debugLine="l = parser.NextArray";
_l = _parser.NextArray();
RDebugUtils.currentLine=2097185;
 //BA.debugLineNum = 2097185;BA.debugLine="If l.Size = 0 Then";
if (_l.getSize()==0) { 
RDebugUtils.currentLine=2097186;
 //BA.debugLineNum = 2097186;BA.debugLine="txtId.Text = \"N/A\"";
mostCurrent._txtid.setText((Object)("N/A"));
 }else {
RDebugUtils.currentLine=2097188;
 //BA.debugLineNum = 2097188;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2097189;
 //BA.debugLineNum = 2097189;BA.debugLine="m = l.Get(0)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_l.Get((int) (0))));
RDebugUtils.currentLine=2097190;
 //BA.debugLineNum = 2097190;BA.debugLine="txtId.Text = m.Get(\"id\")";
mostCurrent._txtid.setText(_m.Get((Object)("id")));
 };
 break;
case 2:
RDebugUtils.currentLine=2097196;
 //BA.debugLineNum = 2097196;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2097197;
 //BA.debugLineNum = 2097197;BA.debugLine="l = parser.NextArray";
_l = _parser.NextArray();
RDebugUtils.currentLine=2097198;
 //BA.debugLineNum = 2097198;BA.debugLine="If l.Size = 0 Then";
if (_l.getSize()==0) { 
RDebugUtils.currentLine=2097199;
 //BA.debugLineNum = 2097199;BA.debugLine="txtId.Text = \"N/A\"";
mostCurrent._txtid.setText((Object)("N/A"));
 }else {
RDebugUtils.currentLine=2097201;
 //BA.debugLineNum = 2097201;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2097202;
 //BA.debugLineNum = 2097202;BA.debugLine="m = l.Get(0)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_l.Get((int) (0))));
RDebugUtils.currentLine=2097203;
 //BA.debugLineNum = 2097203;BA.debugLine="txtId.Text = m.Get(\"id\")";
mostCurrent._txtid.setText(_m.Get((Object)("id")));
RDebugUtils.currentLine=2097204;
 //BA.debugLineNum = 2097204;BA.debugLine="txtNombres.Text =  m.Get(\"nombre\")";
mostCurrent._txtnombres.setText(_m.Get((Object)("nombre")));
 };
 break;
}
;
RDebugUtils.currentLine=2097208;
 //BA.debugLineNum = 2097208;BA.debugLine="Response.Release";
_response.Release();
RDebugUtils.currentLine=2097209;
 //BA.debugLineNum = 2097209;BA.debugLine="End Sub";
return "";
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="eliminar";
b4a.example.listar._renglones _renglon = null;
anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper _req = null;
String _query = "";
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As Object)";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="If IsBackgroundTaskRunning(hc, poblacion) Then ' Está ocupado en llamada anterior.";
if (anywheresoftware.b4a.keywords.Common.IsBackgroundTaskRunning(mostCurrent.activityBA,(Object)(_hc),_poblacion)) { 
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="ToastMessageShow(\"Espera hasta completar la llamada anterior.\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Espera hasta completar la llamada anterior.",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="Dim Renglon As Renglones";
_renglon = new b4a.example.listar._renglones();
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="Renglon = Value";
_renglon = (b4a.example.listar._renglones)(_value);
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="txtNombres.Text = Renglon.Renglon2 ' España";
mostCurrent._txtnombres.setText((Object)(_renglon.Renglon2));
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="borraID = Renglon.Renglon1  ' PARA BORRAR, CÓDIGO JUAN ANTONIO *******";
mostCurrent._borraid = _renglon.Renglon1;
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="txtId.Text = Renglon.Renglon1";
mostCurrent._txtid.setText((Object)(_renglon.Renglon1));
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="Dim req As HttpRequest";
_req = new anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper();
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="Dim Query As String";
_query = "";
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="Query=\"SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE id='\" & Renglon.Renglon1 & \"'\"";
_query = "SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE id='"+_renglon.Renglon1+"'";
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
_req.InitializePost2("http://192.168.241.2:81/paises.php",_query.getBytes("UTF8"));
RDebugUtils.currentLine=2162706;
 //BA.debugLineNum = 2162706;BA.debugLine="hc.Execute(req, poblacion)  '''''''' En ResponseSuccess hará el Case de poblacion";
_hc.Execute(processBA,_req,_poblacion);
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="End Sub";
return "";
}
}