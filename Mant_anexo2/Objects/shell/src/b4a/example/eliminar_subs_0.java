package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class eliminar_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return eliminar.remoteMe.runUserSub(false, "eliminar","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1073741824);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 32;BA.debugLine="hc.Initialize(\"hc\")";
Debug.ShouldStop(-2147483648);
eliminar._hc.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("hc")));
 };
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"lay_eliminar\")";
Debug.ShouldStop(2);
eliminar.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(BA.ObjectToString("lay_eliminar")),eliminar.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="Buscar_lista_de_paises";
Debug.ShouldStop(4);
_buscar_lista_de_paises();
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnbuscar_click() throws Exception{
try {
		Debug.PushSubsStack("btnBuscar_Click (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,163);
if (RapidSub.canDelegate("btnbuscar_click")) return eliminar.remoteMe.runUserSub(false, "eliminar","btnbuscar_click");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _busca = RemoteObject.createImmutable("");
 BA.debugLineNum = 163;BA.debugLine="Sub btnBuscar_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(8);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 165;BA.debugLine="Dim Query As String";
Debug.ShouldStop(16);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 166;BA.debugLine="Dim busca As String";
Debug.ShouldStop(32);
_busca = RemoteObject.createImmutable("");Debug.locals.put("busca", _busca);
 BA.debugLineNum = 167;BA.debugLine="busca = txtBuscar.Text";
Debug.ShouldStop(64);
_busca = eliminar.mostCurrent._txtbuscar.runMethod(true,"getText");Debug.locals.put("busca", _busca);
 BA.debugLineNum = 169;BA.debugLine="Query=\"SELECT * FROM usuario WHERE nombre LIKE '\" & busca & \"'\"";
Debug.ShouldStop(256);
_query = RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM usuario WHERE nombre LIKE '"),_busca,RemoteObject.createImmutable("'"));Debug.locals.put("Query", _query);
 BA.debugLineNum = 171;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(1024);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 172;BA.debugLine="hc.Execute(req, bus)";
Debug.ShouldStop(2048);
eliminar._hc.runVoidMethod ("Execute",eliminar.processBA,(Object)(_req),(Object)(eliminar._bus));
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btneliminar_click() throws Exception{
try {
		Debug.PushSubsStack("btnEliminar_Click (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,143);
if (RapidSub.canDelegate("btneliminar_click")) return eliminar.remoteMe.runUserSub(false, "eliminar","btneliminar_click");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _ids = RemoteObject.createImmutable("");
 BA.debugLineNum = 143;BA.debugLine="Sub btnEliminar_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(65536);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 146;BA.debugLine="Dim Query As String";
Debug.ShouldStop(131072);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 148;BA.debugLine="Dim ids As String";
Debug.ShouldStop(524288);
_ids = RemoteObject.createImmutable("");Debug.locals.put("ids", _ids);
 BA.debugLineNum = 150;BA.debugLine="ids = txtId.Text";
Debug.ShouldStop(2097152);
_ids = eliminar.mostCurrent._txtid.runMethod(true,"getText");Debug.locals.put("ids", _ids);
 BA.debugLineNum = 152;BA.debugLine="Query=\"DELETE FROM usuario  WHERE id='\" & ids & \"'\"";
Debug.ShouldStop(8388608);
_query = RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM usuario  WHERE id='"),_ids,RemoteObject.createImmutable("'"));Debug.locals.put("Query", _query);
 BA.debugLineNum = 154;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(33554432);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 155;BA.debugLine="hc.Execute(req, 4) ' ------- He cambiado esto, 4 es una tarea que no existe en Select";
Debug.ShouldStop(67108864);
eliminar._hc.runVoidMethod ("Execute",eliminar.processBA,(Object)(_req),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 157;BA.debugLine="ListView1.Clear";
Debug.ShouldStop(268435456);
eliminar.mostCurrent._listview1.runVoidMethod ("Clear");
 BA.debugLineNum = 158;BA.debugLine="Buscar_lista_de_paises";
Debug.ShouldStop(536870912);
_buscar_lista_de_paises();
 BA.debugLineNum = 159;BA.debugLine="txtId.Text=\"\"";
Debug.ShouldStop(1073741824);
eliminar.mostCurrent._txtid.runMethod(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 160;BA.debugLine="txtNombres.Text=\"\"";
Debug.ShouldStop(-2147483648);
eliminar.mostCurrent._txtnombres.runMethod(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnirlistar_click() throws Exception{
try {
		Debug.PushSubsStack("btnIrListar_Click (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,174);
if (RapidSub.canDelegate("btnirlistar_click")) return eliminar.remoteMe.runUserSub(false, "eliminar","btnirlistar_click");
 BA.debugLineNum = 174;BA.debugLine="Sub btnIrListar_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="StartActivity(\"listar\")";
Debug.ShouldStop(16384);
eliminar.mostCurrent.__c.runVoidMethod ("StartActivity",eliminar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("listar"))));
 BA.debugLineNum = 176;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
eliminar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buscar_lista_de_paises() throws Exception{
try {
		Debug.PushSubsStack("Buscar_lista_de_paises (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,38);
if (RapidSub.canDelegate("buscar_lista_de_paises")) return eliminar.remoteMe.runUserSub(false, "eliminar","buscar_lista_de_paises");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
 BA.debugLineNum = 38;BA.debugLine="Sub Buscar_lista_de_paises";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="ProgressDialogShow(\"Buscando lista de países.\")";
Debug.ShouldStop(64);
eliminar.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",eliminar.mostCurrent.activityBA,(Object)(BA.ObjectToString("Buscando lista de países.")));
 BA.debugLineNum = 41;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(256);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 42;BA.debugLine="Dim Query As String";
Debug.ShouldStop(512);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 43;BA.debugLine="Query=\"SELECT nombre,apellido,direccion,telefono, id FROM usuario ORDER BY ID\"";
Debug.ShouldStop(1024);
_query = BA.ObjectToString("SELECT nombre,apellido,direccion,telefono, id FROM usuario ORDER BY ID");Debug.locals.put("Query", _query);
 BA.debugLineNum = 45;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(4096);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 46;BA.debugLine="hc.Execute(req, paises) '''''''' En ResponseSuccess hará el Case de paises";
Debug.ShouldStop(8192);
eliminar._hc.runVoidMethod ("Execute",eliminar.processBA,(Object)(_req),(Object)(eliminar._paises));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim ListView1 As ListView";
eliminar.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim borraID As String ' PARA BORRAR, CÓDIGO JUAN ANTONIO *********";
eliminar.mostCurrent._borraid = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Private btnBuscar As Button";
eliminar.mostCurrent._btnbuscar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnEliminar As Button";
eliminar.mostCurrent._btneliminar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtBuscar As EditText";
eliminar.mostCurrent._txtbuscar = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private txtId As Label";
eliminar.mostCurrent._txtid = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtNombres As Label";
eliminar.mostCurrent._txtnombres = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hc_responseerror(RemoteObject _response,RemoteObject _reason,RemoteObject _statuscode,RemoteObject _tarea) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseError (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,133);
if (RapidSub.canDelegate("hc_responseerror")) return eliminar.remoteMe.runUserSub(false, "eliminar","hc_responseerror", _response, _reason, _statuscode, _tarea);
Debug.locals.put("Response", _response);
Debug.locals.put("Reason", _reason);
Debug.locals.put("StatusCode", _statuscode);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 133;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="Log(\"Error: \" & Reason & \", StatusCode: \" & StatusCode)";
Debug.ShouldStop(32);
eliminar.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_reason,RemoteObject.createImmutable(", StatusCode: "),_statuscode)));
 BA.debugLineNum = 135;BA.debugLine="If Response <> Null Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("N",_response)) { 
 BA.debugLineNum = 136;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
Debug.ShouldStop(128);
eliminar.mostCurrent.__c.runVoidMethod ("Log",(Object)(_response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 137;BA.debugLine="Response.Release";
Debug.ShouldStop(256);
_response.runVoidMethod ("Release");
 };
 BA.debugLineNum = 139;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1024);
eliminar.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("hc_ResponseSuccess (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,50);
if (RapidSub.canDelegate("hc_responsesuccess")) return eliminar.remoteMe.runUserSub(false, "eliminar","hc_responsesuccess", _response, _tarea);
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _countries = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _renglon = RemoteObject.declareNull("b4a.example.listar._renglones");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Response", _response);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 50;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Dim res As String";
Debug.ShouldStop(262144);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 52;BA.debugLine="res = Response.GetString(\"UTF8\")";
Debug.ShouldStop(524288);
_res = _response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")));Debug.locals.put("res", _res);
 BA.debugLineNum = 53;BA.debugLine="Log(\"Respuesta del servidor: \" & res)";
Debug.ShouldStop(1048576);
eliminar.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Respuesta del servidor: "),_res)));
 BA.debugLineNum = 55;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(4194304);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 56;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(8388608);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 58;BA.debugLine="Select tarea";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt(_tarea,eliminar._paises,eliminar._poblacion,eliminar._bus)) {
case 0:
 BA.debugLineNum = 63;BA.debugLine="Dim countries As List";
Debug.ShouldStop(1073741824);
_countries = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("countries", _countries);
 BA.debugLineNum = 64;BA.debugLine="countries.Initialize";
Debug.ShouldStop(-2147483648);
_countries.runVoidMethod ("Initialize");
 BA.debugLineNum = 65;BA.debugLine="countries = parser.NextArray";
Debug.ShouldStop(1);
_countries = _parser.runMethod(false,"NextArray");Debug.locals.put("countries", _countries);
 BA.debugLineNum = 66;BA.debugLine="For i = 0 To countries.Size - 1";
Debug.ShouldStop(2);
{
final int step42 = 1;
final int limit42 = RemoteObject.solve(new RemoteObject[] {_countries.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0; (step42 > 0 && _i <= limit42) || (step42 < 0 && _i >= limit42); _i = ((int)(0 + _i + step42))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 67;BA.debugLine="Dim m As Map";
Debug.ShouldStop(4);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 68;BA.debugLine="m = countries.Get(i)";
Debug.ShouldStop(8);
_m.setObject(_countries.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 69;BA.debugLine="Dim Renglon As Renglones";
Debug.ShouldStop(16);
_renglon = RemoteObject.createNew ("b4a.example.listar._renglones");Debug.locals.put("Renglon", _renglon);
 BA.debugLineNum = 70;BA.debugLine="Renglon.Renglon1 = m.Get(\"id\")      ' ES";
Debug.ShouldStop(32);
_renglon.setField ("Renglon1",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("id"))))));
 BA.debugLineNum = 71;BA.debugLine="Renglon.Renglon2 = m.Get(\"nombre\")  ' España";
Debug.ShouldStop(64);
_renglon.setField ("Renglon2",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("nombre"))))));
 BA.debugLineNum = 72;BA.debugLine="Renglon.Renglon3 = m.Get(\"apellido\")  ' España";
Debug.ShouldStop(128);
_renglon.setField ("Renglon3",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("apellido"))))));
 BA.debugLineNum = 73;BA.debugLine="Renglon.Renglon4 = m.Get(\"direccion\")  ' España";
Debug.ShouldStop(256);
_renglon.setField ("Renglon4",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("direccion"))))));
 BA.debugLineNum = 74;BA.debugLine="Renglon.Renglon5 = m.Get(\"telefono\")  ' España";
Debug.ShouldStop(512);
_renglon.setField ("Renglon5",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("telefono"))))));
 BA.debugLineNum = 75;BA.debugLine="ListView1.AddTwoLines2(Renglon.Renglon1, Renglon.Renglon2 & \"   \" &  Renglon.Renglon3 , Renglon)";
Debug.ShouldStop(1024);
eliminar.mostCurrent._listview1.runVoidMethod ("AddTwoLines2",(Object)(_renglon.getField(true,"Renglon1")),(Object)(RemoteObject.concat(_renglon.getField(true,"Renglon2"),RemoteObject.createImmutable("   "),_renglon.getField(true,"Renglon3"))),(Object)((_renglon)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 77;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(4096);
eliminar.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break;
case 1:
 BA.debugLineNum = 81;BA.debugLine="Dim l As List";
Debug.ShouldStop(65536);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 82;BA.debugLine="l = parser.NextArray";
Debug.ShouldStop(131072);
_l = _parser.runMethod(false,"NextArray");Debug.locals.put("l", _l);
 BA.debugLineNum = 83;BA.debugLine="If l.Size = 0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_l.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 84;BA.debugLine="txtId.Text = \"N/A\"";
Debug.ShouldStop(524288);
eliminar.mostCurrent._txtid.runMethod(true,"setText",RemoteObject.createImmutable(("N/A")));
 }else {
 BA.debugLineNum = 86;BA.debugLine="Dim m As Map";
Debug.ShouldStop(2097152);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 87;BA.debugLine="m = l.Get(0)";
Debug.ShouldStop(4194304);
_m.setObject(_l.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 88;BA.debugLine="txtId.Text = m.Get(\"id\")";
Debug.ShouldStop(8388608);
eliminar.mostCurrent._txtid.runMethod(true,"setText",_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("id")))));
 };
 break;
case 2:
 BA.debugLineNum = 94;BA.debugLine="Dim l As List";
Debug.ShouldStop(536870912);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 95;BA.debugLine="l = parser.NextArray";
Debug.ShouldStop(1073741824);
_l = _parser.runMethod(false,"NextArray");Debug.locals.put("l", _l);
 BA.debugLineNum = 96;BA.debugLine="If l.Size = 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_l.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 97;BA.debugLine="txtId.Text = \"N/A\"";
Debug.ShouldStop(1);
eliminar.mostCurrent._txtid.runMethod(true,"setText",RemoteObject.createImmutable(("N/A")));
 }else {
 BA.debugLineNum = 99;BA.debugLine="Dim m As Map";
Debug.ShouldStop(4);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 100;BA.debugLine="m = l.Get(0)";
Debug.ShouldStop(8);
_m.setObject(_l.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 101;BA.debugLine="txtId.Text = m.Get(\"id\")";
Debug.ShouldStop(16);
eliminar.mostCurrent._txtid.runMethod(true,"setText",_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("id")))));
 BA.debugLineNum = 102;BA.debugLine="txtNombres.Text =  m.Get(\"nombre\")";
Debug.ShouldStop(32);
eliminar.mostCurrent._txtnombres.runMethod(true,"setText",_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("nombre")))));
 };
 break;
}
;
 BA.debugLineNum = 106;BA.debugLine="Response.Release";
Debug.ShouldStop(512);
_response.runVoidMethod ("Release");
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listview1_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListView1_ItemClick (eliminar) ","eliminar",3,eliminar.mostCurrent.activityBA,eliminar.mostCurrent,110);
if (RapidSub.canDelegate("listview1_itemclick")) return eliminar.remoteMe.runUserSub(false, "eliminar","listview1_itemclick", _position, _value);
RemoteObject _renglon = RemoteObject.declareNull("b4a.example.listar._renglones");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 110;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As Object)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 112;BA.debugLine="If IsBackgroundTaskRunning(hc, poblacion) Then ' Está ocupado en llamada anterior.";
Debug.ShouldStop(32768);
if (eliminar.mostCurrent.__c.runMethod(true,"IsBackgroundTaskRunning",eliminar.mostCurrent.activityBA,(Object)((eliminar._hc)),(Object)(eliminar._poblacion)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 113;BA.debugLine="ToastMessageShow(\"Espera hasta completar la llamada anterior.\", False)";
Debug.ShouldStop(65536);
eliminar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Espera hasta completar la llamada anterior.")),(Object)(eliminar.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 114;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 117;BA.debugLine="Dim Renglon As Renglones";
Debug.ShouldStop(1048576);
_renglon = RemoteObject.createNew ("b4a.example.listar._renglones");Debug.locals.put("Renglon", _renglon);
 BA.debugLineNum = 118;BA.debugLine="Renglon = Value";
Debug.ShouldStop(2097152);
_renglon = (_value);Debug.locals.put("Renglon", _renglon);
 BA.debugLineNum = 119;BA.debugLine="txtNombres.Text = Renglon.Renglon2 ' España";
Debug.ShouldStop(4194304);
eliminar.mostCurrent._txtnombres.runMethod(true,"setText",(_renglon.getField(true,"Renglon2")));
 BA.debugLineNum = 120;BA.debugLine="borraID = Renglon.Renglon1  ' PARA BORRAR, CÓDIGO JUAN ANTONIO *******";
Debug.ShouldStop(8388608);
eliminar.mostCurrent._borraid = _renglon.getField(true,"Renglon1");
 BA.debugLineNum = 121;BA.debugLine="txtId.Text = Renglon.Renglon1";
Debug.ShouldStop(16777216);
eliminar.mostCurrent._txtid.runMethod(true,"setText",(_renglon.getField(true,"Renglon1")));
 BA.debugLineNum = 123;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(67108864);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 124;BA.debugLine="Dim Query As String";
Debug.ShouldStop(134217728);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 125;BA.debugLine="Query=\"SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE id='\" & Renglon.Renglon1 & \"'\"";
Debug.ShouldStop(268435456);
_query = RemoteObject.concat(RemoteObject.createImmutable("SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE id='"),_renglon.getField(true,"Renglon1"),RemoteObject.createImmutable("'"));Debug.locals.put("Query", _query);
 BA.debugLineNum = 127;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(1073741824);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 128;BA.debugLine="hc.Execute(req, poblacion)  '''''''' En ResponseSuccess hará el Case de poblacion";
Debug.ShouldStop(-2147483648);
eliminar._hc.runVoidMethod ("Execute",eliminar.processBA,(Object)(_req),(Object)(eliminar._poblacion));
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
eliminar._hc = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper");
 //BA.debugLineNum = 8;BA.debugLine="Dim paises, poblacion, bus As Int";
eliminar._paises = RemoteObject.createImmutable(0);
eliminar._poblacion = RemoteObject.createImmutable(0);
eliminar._bus = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 9;BA.debugLine="paises = 1    ' Es la tarea 1";
eliminar._paises = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 10;BA.debugLine="poblacion = 2 ' Es la tarea 2";
eliminar._poblacion = BA.numberCast(int.class, 2);
 //BA.debugLineNum = 11;BA.debugLine="bus = 3 ' Es la tarea 3 PARA BUSCAR, CÓDIGO JUAN ANTONIO ------";
eliminar._bus = BA.numberCast(int.class, 3);
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}