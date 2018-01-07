package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actualizar_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) return actualizar.remoteMe.runUserSub(false, "actualizar","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 24;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(8388608);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 25;BA.debugLine="hc.Initialize(\"hc\")";
Debug.ShouldStop(16777216);
actualizar._hc.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("hc")));
 };
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"lay_actualizar\")";
Debug.ShouldStop(268435456);
actualizar.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(BA.ObjectToString("lay_actualizar")),actualizar.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Pause (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,37);
if (RapidSub.canDelegate("activity_pause")) return actualizar.remoteMe.runUserSub(false, "actualizar","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Resume (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,33);
if (RapidSub.canDelegate("activity_resume")) return actualizar.remoteMe.runUserSub(false, "actualizar","activity_resume");
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnactualizar_click() throws Exception{
try {
		Debug.PushSubsStack("btnActualizar_Click (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,42);
if (RapidSub.canDelegate("btnactualizar_click")) return actualizar.remoteMe.runUserSub(false, "actualizar","btnactualizar_click");
RemoteObject _ids = RemoteObject.createImmutable("");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
 BA.debugLineNum = 42;BA.debugLine="Sub btnActualizar_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="nombre = txtNombre.Text";
Debug.ShouldStop(1024);
actualizar.mostCurrent._nombre = actualizar.mostCurrent._txtnombre.runMethod(true,"getText");
 BA.debugLineNum = 44;BA.debugLine="apellido = txtApellido.Text";
Debug.ShouldStop(2048);
actualizar.mostCurrent._apellido = actualizar.mostCurrent._txtapellido.runMethod(true,"getText");
 BA.debugLineNum = 45;BA.debugLine="direccion = txtDireccion.Text";
Debug.ShouldStop(4096);
actualizar.mostCurrent._direccion = actualizar.mostCurrent._txtdireccion.runMethod(true,"getText");
 BA.debugLineNum = 46;BA.debugLine="telefono = txtTelefono.Text";
Debug.ShouldStop(8192);
actualizar.mostCurrent._telefono = actualizar.mostCurrent._txttelefono.runMethod(true,"getText");
 BA.debugLineNum = 48;BA.debugLine="Dim ids As String";
Debug.ShouldStop(32768);
_ids = RemoteObject.createImmutable("");Debug.locals.put("ids", _ids);
 BA.debugLineNum = 50;BA.debugLine="ids = txtId.Text";
Debug.ShouldStop(131072);
_ids = actualizar.mostCurrent._txtid.runMethod(true,"getText");Debug.locals.put("ids", _ids);
 BA.debugLineNum = 52;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(524288);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 53;BA.debugLine="Dim Query As String";
Debug.ShouldStop(1048576);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 54;BA.debugLine="Query=\"UPDATE usuario SET nombre='\" & nombre & \"', apellido='\" & apellido & \"',direccion='\" & direccion & \"',telefono='\" & telefono & \"' WHERE id='\" & ids & \"'\"";
Debug.ShouldStop(2097152);
_query = RemoteObject.concat(RemoteObject.createImmutable("UPDATE usuario SET nombre='"),actualizar.mostCurrent._nombre,RemoteObject.createImmutable("', apellido='"),actualizar.mostCurrent._apellido,RemoteObject.createImmutable("',direccion='"),actualizar.mostCurrent._direccion,RemoteObject.createImmutable("',telefono='"),actualizar.mostCurrent._telefono,RemoteObject.createImmutable("' WHERE id='"),_ids,RemoteObject.createImmutable("'"));Debug.locals.put("Query", _query);
 BA.debugLineNum = 55;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(4194304);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 56;BA.debugLine="hc.Execute(req, 1)";
Debug.ShouldStop(8388608);
actualizar._hc.runVoidMethod ("Execute",actualizar.processBA,(Object)(_req),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 59;BA.debugLine="txtNombre.Text=\"\"";
Debug.ShouldStop(67108864);
actualizar.mostCurrent._txtnombre.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 60;BA.debugLine="txtApellido.Text=\"\"";
Debug.ShouldStop(134217728);
actualizar.mostCurrent._txtapellido.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 61;BA.debugLine="txtDireccion.Text=\"\"";
Debug.ShouldStop(268435456);
actualizar.mostCurrent._txtdireccion.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 62;BA.debugLine="txtTelefono.Text=\"\"";
Debug.ShouldStop(536870912);
actualizar.mostCurrent._txttelefono.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
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
public static RemoteObject  _btnlistar_click() throws Exception{
try {
		Debug.PushSubsStack("btnListar_Click (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,67);
if (RapidSub.canDelegate("btnlistar_click")) return actualizar.remoteMe.runUserSub(false, "actualizar","btnlistar_click");
 BA.debugLineNum = 67;BA.debugLine="Sub btnListar_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="StartActivity(\"listar\")";
Debug.ShouldStop(8);
actualizar.mostCurrent.__c.runVoidMethod ("StartActivity",actualizar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("listar"))));
 BA.debugLineNum = 69;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
actualizar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
actualizar.mostCurrent._id = RemoteObject.createImmutable("");
actualizar.mostCurrent._nombre = RemoteObject.createImmutable("");
actualizar.mostCurrent._apellido = RemoteObject.createImmutable("");
actualizar.mostCurrent._direccion = RemoteObject.createImmutable("");
actualizar.mostCurrent._telefono = RemoteObject.createImmutable("");
actualizar.mostCurrent._datos = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Private txtApellido As EditText";
actualizar.mostCurrent._txtapellido = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private txtDireccion As EditText";
actualizar.mostCurrent._txtdireccion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtNombre As EditText";
actualizar.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtTelefono As EditText";
actualizar.mostCurrent._txttelefono = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtId As EditText";
actualizar.mostCurrent._txtid = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hc_responseerror(RemoteObject _response,RemoteObject _reason,RemoteObject _statuscode,RemoteObject _tarea) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseError (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,81);
if (RapidSub.canDelegate("hc_responseerror")) return actualizar.remoteMe.runUserSub(false, "actualizar","hc_responseerror", _response, _reason, _statuscode, _tarea);
Debug.locals.put("Response", _response);
Debug.locals.put("Reason", _reason);
Debug.locals.put("StatusCode", _statuscode);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 81;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="Log(\"Error: \" & Reason & \", StatusCode: \" & StatusCode)";
Debug.ShouldStop(131072);
actualizar.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_reason,RemoteObject.createImmutable(", StatusCode: "),_statuscode)));
 BA.debugLineNum = 83;BA.debugLine="If Response <> Null Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("N",_response)) { 
 BA.debugLineNum = 84;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
Debug.ShouldStop(524288);
actualizar.mostCurrent.__c.runVoidMethod ("Log",(Object)(_response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 85;BA.debugLine="Response.Release";
Debug.ShouldStop(1048576);
_response.runVoidMethod ("Release");
 };
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("hc_ResponseSuccess (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,74);
if (RapidSub.canDelegate("hc_responsesuccess")) return actualizar.remoteMe.runUserSub(false, "actualizar","hc_responsesuccess", _response, _tarea);
RemoteObject _resultstring = RemoteObject.createImmutable("");
Debug.locals.put("Response", _response);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 74;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Dim resultString As String";
Debug.ShouldStop(1024);
_resultstring = RemoteObject.createImmutable("");Debug.locals.put("resultString", _resultstring);
 BA.debugLineNum = 76;BA.debugLine="resultString = Response.GetString(\"UTF8\")";
Debug.ShouldStop(2048);
_resultstring = _response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")));Debug.locals.put("resultString", _resultstring);
 BA.debugLineNum = 78;BA.debugLine="Msgbox(\"Los datos han sido almacenados\", \"Éxito de operación\")";
Debug.ShouldStop(8192);
actualizar.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Los datos han sido almacenados")),(Object)(BA.ObjectToString("Éxito de operación")),actualizar.mostCurrent.activityBA);
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
actualizar._hc = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}