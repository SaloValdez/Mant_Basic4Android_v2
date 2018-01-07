package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class insertar_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) return insertar.remoteMe.runUserSub(false, "insertar","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(4194304);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 24;BA.debugLine="hc.Initialize(\"hc\")";
Debug.ShouldStop(8388608);
insertar._hc.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("hc")));
 };
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"lay_insertar\")";
Debug.ShouldStop(134217728);
insertar.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(BA.ObjectToString("lay_insertar")),insertar.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,36);
if (RapidSub.canDelegate("activity_pause")) return insertar.remoteMe.runUserSub(false, "insertar","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,32);
if (RapidSub.canDelegate("activity_resume")) return insertar.remoteMe.runUserSub(false, "insertar","activity_resume");
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btninsertar_click() throws Exception{
try {
		Debug.PushSubsStack("btnInsertar_Click (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,40);
if (RapidSub.canDelegate("btninsertar_click")) return insertar.remoteMe.runUserSub(false, "insertar","btninsertar_click");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
 BA.debugLineNum = 40;BA.debugLine="Sub btnInsertar_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="nombre = txtNombre.Text";
Debug.ShouldStop(256);
insertar.mostCurrent._nombre = insertar.mostCurrent._txtnombre.runMethod(true,"getText");
 BA.debugLineNum = 42;BA.debugLine="apellido = txtApellido.Text";
Debug.ShouldStop(512);
insertar.mostCurrent._apellido = insertar.mostCurrent._txtapellido.runMethod(true,"getText");
 BA.debugLineNum = 43;BA.debugLine="direccion = txtDireccion.Text";
Debug.ShouldStop(1024);
insertar.mostCurrent._direccion = insertar.mostCurrent._txtdireccion.runMethod(true,"getText");
 BA.debugLineNum = 44;BA.debugLine="telefono = txtTelefono.Text";
Debug.ShouldStop(2048);
insertar.mostCurrent._telefono = insertar.mostCurrent._txttelefono.runMethod(true,"getText");
 BA.debugLineNum = 46;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(8192);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 47;BA.debugLine="Dim Query As String";
Debug.ShouldStop(16384);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 48;BA.debugLine="Query=\"INSERT INTO usuario (nombre, apellido,direccion,telefono) VALUES ('\" & nombre & \"','\" & apellido & \"','\" & direccion & \"','\" & telefono & \"')\"";
Debug.ShouldStop(32768);
_query = RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO usuario (nombre, apellido,direccion,telefono) VALUES ('"),insertar.mostCurrent._nombre,RemoteObject.createImmutable("','"),insertar.mostCurrent._apellido,RemoteObject.createImmutable("','"),insertar.mostCurrent._direccion,RemoteObject.createImmutable("','"),insertar.mostCurrent._telefono,RemoteObject.createImmutable("')"));Debug.locals.put("Query", _query);
 BA.debugLineNum = 49;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(65536);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 50;BA.debugLine="hc.Execute(req, 1)";
Debug.ShouldStop(131072);
insertar._hc.runVoidMethod ("Execute",insertar.processBA,(Object)(_req),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 53;BA.debugLine="txtNombre.Text=\"\"";
Debug.ShouldStop(1048576);
insertar.mostCurrent._txtnombre.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 54;BA.debugLine="txtApellido.Text=\"\"";
Debug.ShouldStop(2097152);
insertar.mostCurrent._txtapellido.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 55;BA.debugLine="txtDireccion.Text=\"\"";
Debug.ShouldStop(4194304);
insertar.mostCurrent._txtdireccion.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 56;BA.debugLine="txtTelefono.Text=\"\"";
Debug.ShouldStop(8388608);
insertar.mostCurrent._txttelefono.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnlistar_click() throws Exception{
try {
		Debug.PushSubsStack("btnListar_Click (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,59);
if (RapidSub.canDelegate("btnlistar_click")) return insertar.remoteMe.runUserSub(false, "insertar","btnlistar_click");
 BA.debugLineNum = 59;BA.debugLine="Sub btnListar_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="StartActivity(\"listar\")";
Debug.ShouldStop(134217728);
insertar.mostCurrent.__c.runVoidMethod ("StartActivity",insertar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("listar"))));
 BA.debugLineNum = 61;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
insertar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim id, nombre, apellido,direccion,telefono, datos As String";
insertar.mostCurrent._id = RemoteObject.createImmutable("");
insertar.mostCurrent._nombre = RemoteObject.createImmutable("");
insertar.mostCurrent._apellido = RemoteObject.createImmutable("");
insertar.mostCurrent._direccion = RemoteObject.createImmutable("");
insertar.mostCurrent._telefono = RemoteObject.createImmutable("");
insertar.mostCurrent._datos = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Private txtApellido As EditText";
insertar.mostCurrent._txtapellido = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private txtDireccion As EditText";
insertar.mostCurrent._txtdireccion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtNombre As EditText";
insertar.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtTelefono As EditText";
insertar.mostCurrent._txttelefono = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hc_responseerror(RemoteObject _response,RemoteObject _reason,RemoteObject _statuscode,RemoteObject _tarea) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseError (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,74);
if (RapidSub.canDelegate("hc_responseerror")) return insertar.remoteMe.runUserSub(false, "insertar","hc_responseerror", _response, _reason, _statuscode, _tarea);
Debug.locals.put("Response", _response);
Debug.locals.put("Reason", _reason);
Debug.locals.put("StatusCode", _statuscode);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 74;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Log(\"Error: \" & Reason & \", StatusCode: \" & StatusCode)";
Debug.ShouldStop(1024);
insertar.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_reason,RemoteObject.createImmutable(", StatusCode: "),_statuscode)));
 BA.debugLineNum = 76;BA.debugLine="If Response <> Null Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("N",_response)) { 
 BA.debugLineNum = 77;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
Debug.ShouldStop(4096);
insertar.mostCurrent.__c.runVoidMethod ("Log",(Object)(_response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 78;BA.debugLine="Response.Release";
Debug.ShouldStop(8192);
_response.runVoidMethod ("Release");
 };
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _hc_responsesuccess(RemoteObject _response,RemoteObject _tarea) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseSuccess (insertar) ","insertar",2,insertar.mostCurrent.activityBA,insertar.mostCurrent,67);
if (RapidSub.canDelegate("hc_responsesuccess")) return insertar.remoteMe.runUserSub(false, "insertar","hc_responsesuccess", _response, _tarea);
RemoteObject _resultstring = RemoteObject.createImmutable("");
Debug.locals.put("Response", _response);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 67;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Dim resultString As String";
Debug.ShouldStop(8);
_resultstring = RemoteObject.createImmutable("");Debug.locals.put("resultString", _resultstring);
 BA.debugLineNum = 69;BA.debugLine="resultString = Response.GetString(\"UTF8\")";
Debug.ShouldStop(16);
_resultstring = _response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")));Debug.locals.put("resultString", _resultstring);
 BA.debugLineNum = 71;BA.debugLine="Msgbox(\"Los datos han sido almacenados\", \"Éxito de operación\")";
Debug.ShouldStop(64);
insertar.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Los datos han sido almacenados")),(Object)(BA.ObjectToString("Éxito de operación")),insertar.mostCurrent.activityBA);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim hc As HttpClient";
insertar._hc = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}