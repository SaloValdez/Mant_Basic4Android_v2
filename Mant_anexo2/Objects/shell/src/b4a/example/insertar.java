
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class insertar implements IRemote{
	public static insertar mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public insertar() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4a.example.insertar", "b4a.example.insertar");
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
		pcBA = new PCBA(this, insertar.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _hc = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper");
public static RemoteObject _id = RemoteObject.createImmutable("");
public static RemoteObject _nombre = RemoteObject.createImmutable("");
public static RemoteObject _apellido = RemoteObject.createImmutable("");
public static RemoteObject _direccion = RemoteObject.createImmutable("");
public static RemoteObject _telefono = RemoteObject.createImmutable("");
public static RemoteObject _datos = RemoteObject.createImmutable("");
public static RemoteObject _txtapellido = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtdireccion = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txttelefono = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static b4a.example.main _main = null;
public static b4a.example.listar _listar = null;
public static b4a.example.eliminar _eliminar = null;
public static b4a.example.actualizar _actualizar = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",insertar.mostCurrent._activity,"actualizar",Debug.moduleToString(b4a.example.actualizar.class),"apellido",insertar.mostCurrent._apellido,"datos",insertar.mostCurrent._datos,"direccion",insertar.mostCurrent._direccion,"eliminar",Debug.moduleToString(b4a.example.eliminar.class),"hc",insertar._hc,"id",insertar.mostCurrent._id,"listar",Debug.moduleToString(b4a.example.listar.class),"Main",Debug.moduleToString(b4a.example.main.class),"nombre",insertar.mostCurrent._nombre,"telefono",insertar.mostCurrent._telefono,"txtApellido",insertar.mostCurrent._txtapellido,"txtDireccion",insertar.mostCurrent._txtdireccion,"txtNombre",insertar.mostCurrent._txtnombre,"txtTelefono",insertar.mostCurrent._txttelefono};
}
}