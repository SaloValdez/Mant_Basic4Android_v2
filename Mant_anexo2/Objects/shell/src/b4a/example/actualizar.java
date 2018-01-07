
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class actualizar implements IRemote{
	public static actualizar mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public actualizar() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4a.example.actualizar", "b4a.example.actualizar");
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
		pcBA = new PCBA(this, actualizar.class);
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
public static RemoteObject _txtid = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static b4a.example.main _main = null;
public static b4a.example.listar _listar = null;
public static b4a.example.insertar _insertar = null;
public static b4a.example.eliminar _eliminar = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",actualizar.mostCurrent._activity,"apellido",actualizar.mostCurrent._apellido,"datos",actualizar.mostCurrent._datos,"direccion",actualizar.mostCurrent._direccion,"eliminar",Debug.moduleToString(b4a.example.eliminar.class),"hc",actualizar._hc,"id",actualizar.mostCurrent._id,"insertar",Debug.moduleToString(b4a.example.insertar.class),"listar",Debug.moduleToString(b4a.example.listar.class),"Main",Debug.moduleToString(b4a.example.main.class),"nombre",actualizar.mostCurrent._nombre,"telefono",actualizar.mostCurrent._telefono,"txtApellido",actualizar.mostCurrent._txtapellido,"txtDireccion",actualizar.mostCurrent._txtdireccion,"txtId",actualizar.mostCurrent._txtid,"txtNombre",actualizar.mostCurrent._txtnombre,"txtTelefono",actualizar.mostCurrent._txttelefono};
}
}