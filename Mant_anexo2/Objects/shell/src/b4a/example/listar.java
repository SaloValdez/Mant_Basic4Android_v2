
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class listar implements IRemote{
	public static listar mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public listar() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4a.example.listar", "b4a.example.listar");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, listar.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _hc = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper");
public static RemoteObject _paises = RemoteObject.createImmutable(0);
public static RemoteObject _poblacion = RemoteObject.createImmutable(0);
public static RemoteObject _listview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _btnprincipal = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btninsertar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.main _main = null;
public static b4a.example.insertar _insertar = null;
public static b4a.example.eliminar _eliminar = null;
public static b4a.example.actualizar _actualizar = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",listar.mostCurrent._activity,"actualizar",Debug.moduleToString(b4a.example.actualizar.class),"btnInsertar",listar.mostCurrent._btninsertar,"btnPrincipal",listar.mostCurrent._btnprincipal,"eliminar",Debug.moduleToString(b4a.example.eliminar.class),"hc",listar._hc,"insertar",Debug.moduleToString(b4a.example.insertar.class),"ListView1",listar.mostCurrent._listview1,"Main",Debug.moduleToString(b4a.example.main.class),"paises",listar._paises,"poblacion",listar._poblacion};
}
}