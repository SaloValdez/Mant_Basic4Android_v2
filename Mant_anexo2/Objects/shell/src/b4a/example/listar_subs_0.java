package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class listar_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) return listar.remoteMe.runUserSub(false, "listar","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(134217728);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 29;BA.debugLine="hc.Initialize(\"hc\")";
Debug.ShouldStop(268435456);
listar._hc.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("hc")));
 };
 BA.debugLineNum = 31;BA.debugLine="Buscar_lista_de_paises";
Debug.ShouldStop(1073741824);
_buscar_lista_de_paises();
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"lay_listar\")";
Debug.ShouldStop(1);
listar.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(BA.ObjectToString("lay_listar")),listar.mostCurrent.activityBA);
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,143);
if (RapidSub.canDelegate("activity_pause")) return listar.remoteMe.runUserSub(false, "listar","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 143;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,139);
if (RapidSub.canDelegate("activity_resume")) return listar.remoteMe.runUserSub(false, "listar","activity_resume");
 BA.debugLineNum = 139;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 141;BA.debugLine="End Sub";
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
public static RemoteObject  _btnactualizar_click() throws Exception{
try {
		Debug.PushSubsStack("btnActualizar_Click (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,161);
if (RapidSub.canDelegate("btnactualizar_click")) return listar.remoteMe.runUserSub(false, "listar","btnactualizar_click");
 BA.debugLineNum = 161;BA.debugLine="Sub btnActualizar_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="StartActivity(\"Actualizar\")";
Debug.ShouldStop(2);
listar.mostCurrent.__c.runVoidMethod ("StartActivity",listar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("Actualizar"))));
 BA.debugLineNum = 163;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
listar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 164;BA.debugLine="End Sub";
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
public static RemoteObject  _btninsertar_click() throws Exception{
try {
		Debug.PushSubsStack("btnInsertar_Click (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,152);
if (RapidSub.canDelegate("btninsertar_click")) return listar.remoteMe.runUserSub(false, "listar","btninsertar_click");
 BA.debugLineNum = 152;BA.debugLine="Sub btnInsertar_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="StartActivity(\"insertar\")";
Debug.ShouldStop(16777216);
listar.mostCurrent.__c.runVoidMethod ("StartActivity",listar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("insertar"))));
 BA.debugLineNum = 155;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
listar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnireliminar_click() throws Exception{
try {
		Debug.PushSubsStack("btnIrEliminar_Click (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,157);
if (RapidSub.canDelegate("btnireliminar_click")) return listar.remoteMe.runUserSub(false, "listar","btnireliminar_click");
 BA.debugLineNum = 157;BA.debugLine="Sub btnIrEliminar_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="StartActivity(\"eliminar\")";
Debug.ShouldStop(536870912);
listar.mostCurrent.__c.runVoidMethod ("StartActivity",listar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("eliminar"))));
 BA.debugLineNum = 159;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
listar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 160;BA.debugLine="End Sub";
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
public static RemoteObject  _btnprincipal_click() throws Exception{
try {
		Debug.PushSubsStack("btnPrincipal_Click (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,147);
if (RapidSub.canDelegate("btnprincipal_click")) return listar.remoteMe.runUserSub(false, "listar","btnprincipal_click");
 BA.debugLineNum = 147;BA.debugLine="Sub btnPrincipal_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(524288);
listar.mostCurrent.__c.runVoidMethod ("StartActivity",listar.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable(("Main"))));
 BA.debugLineNum = 149;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
listar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Buscar_lista_de_paises (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,37);
if (RapidSub.canDelegate("buscar_lista_de_paises")) return listar.remoteMe.runUserSub(false, "listar","buscar_lista_de_paises");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
 BA.debugLineNum = 37;BA.debugLine="Sub Buscar_lista_de_paises";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="ProgressDialogShow(\"Buscando lista de países.\")";
Debug.ShouldStop(32);
listar.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",listar.mostCurrent.activityBA,(Object)(BA.ObjectToString("Buscando lista de países.")));
 BA.debugLineNum = 40;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(128);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 41;BA.debugLine="Dim Query As String";
Debug.ShouldStop(256);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 42;BA.debugLine="Query=\"SELECT id,nombre,apellido,direccion,telefono FROM usuario ORDER BY id\"";
Debug.ShouldStop(512);
_query = BA.ObjectToString("SELECT id,nombre,apellido,direccion,telefono FROM usuario ORDER BY id");Debug.locals.put("Query", _query);
 BA.debugLineNum = 43;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(1024);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 44;BA.debugLine="hc.Execute(req, paises) '''''''' En ResponseSuccess hará el Case de paises";
Debug.ShouldStop(2048);
listar._hc.runVoidMethod ("Execute",listar.processBA,(Object)(_req),(Object)(listar._paises));
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
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Type Renglones (Renglon1 As String, Renglon2 As String,Renglon3 As String,Renglon4 As String,Renglon5 As String)";
;
 //BA.debugLineNum = 19;BA.debugLine="Dim ListView1 As ListView";
listar.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btnPrincipal As Button";
listar.mostCurrent._btnprincipal = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private btnInsertar As Button";
listar.mostCurrent._btninsertar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hc_responseerror(RemoteObject _response,RemoteObject _reason,RemoteObject _statuscode,RemoteObject _tarea) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseError (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,130);
if (RapidSub.canDelegate("hc_responseerror")) return listar.remoteMe.runUserSub(false, "listar","hc_responseerror", _response, _reason, _statuscode, _tarea);
Debug.locals.put("Response", _response);
Debug.locals.put("Reason", _reason);
Debug.locals.put("StatusCode", _statuscode);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 130;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="Log(\"Error: \" & Reason & \", StatusCode: \" & StatusCode)";
Debug.ShouldStop(4);
listar.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_reason,RemoteObject.createImmutable(", StatusCode: "),_statuscode)));
 BA.debugLineNum = 132;BA.debugLine="If Response <> Null Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("N",_response)) { 
 BA.debugLineNum = 133;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
Debug.ShouldStop(16);
listar.mostCurrent.__c.runVoidMethod ("Log",(Object)(_response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 134;BA.debugLine="Response.Release";
Debug.ShouldStop(32);
_response.runVoidMethod ("Release");
 };
 BA.debugLineNum = 136;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(128);
listar.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("hc_ResponseSuccess (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,51);
if (RapidSub.canDelegate("hc_responsesuccess")) return listar.remoteMe.runUserSub(false, "listar","hc_responsesuccess", _response, _tarea);
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _countries = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _renglon = RemoteObject.declareNull("b4a.example.listar._renglones");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Response", _response);
Debug.locals.put("tarea", _tarea);
 BA.debugLineNum = 51;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="Dim res As String";
Debug.ShouldStop(524288);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 53;BA.debugLine="res = Response.GetString(\"UTF8\")";
Debug.ShouldStop(1048576);
_res = _response.runMethod(true,"GetString",(Object)(BA.ObjectToString("UTF8")));Debug.locals.put("res", _res);
 BA.debugLineNum = 54;BA.debugLine="Log(\"Respuesta del servidor: \" & res)";
Debug.ShouldStop(2097152);
listar.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Respuesta del servidor: "),_res)));
 BA.debugLineNum = 56;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8388608);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 57;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(16777216);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 59;BA.debugLine="Select tarea";
Debug.ShouldStop(67108864);
switch (BA.switchObjectToInt(_tarea,listar._paises,listar._poblacion)) {
case 0:
 BA.debugLineNum = 64;BA.debugLine="Dim countries As List";
Debug.ShouldStop(-2147483648);
_countries = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("countries", _countries);
 BA.debugLineNum = 65;BA.debugLine="countries.Initialize";
Debug.ShouldStop(1);
_countries.runVoidMethod ("Initialize");
 BA.debugLineNum = 66;BA.debugLine="countries = parser.NextArray";
Debug.ShouldStop(2);
_countries = _parser.runMethod(false,"NextArray");Debug.locals.put("countries", _countries);
 BA.debugLineNum = 67;BA.debugLine="For i = 0 To countries.Size - 1";
Debug.ShouldStop(4);
{
final int step38 = 1;
final int limit38 = RemoteObject.solve(new RemoteObject[] {_countries.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0; (step38 > 0 && _i <= limit38) || (step38 < 0 && _i >= limit38); _i = ((int)(0 + _i + step38))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 68;BA.debugLine="Dim m As Map";
Debug.ShouldStop(8);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 69;BA.debugLine="m = countries.Get(i)";
Debug.ShouldStop(16);
_m.setObject(_countries.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 70;BA.debugLine="Dim Renglon As Renglones";
Debug.ShouldStop(32);
_renglon = RemoteObject.createNew ("b4a.example.listar._renglones");Debug.locals.put("Renglon", _renglon);
 BA.debugLineNum = 71;BA.debugLine="Renglon.Renglon1 = m.Get(\"id\")      ' ES";
Debug.ShouldStop(64);
_renglon.setField ("Renglon1",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("id"))))));
 BA.debugLineNum = 72;BA.debugLine="Renglon.Renglon2 = m.Get(\"nombre\")  ' España";
Debug.ShouldStop(128);
_renglon.setField ("Renglon2",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("nombre"))))));
 BA.debugLineNum = 73;BA.debugLine="Renglon.Renglon3 = m.Get(\"apellido\")  ' España";
Debug.ShouldStop(256);
_renglon.setField ("Renglon3",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("apellido"))))));
 BA.debugLineNum = 74;BA.debugLine="Renglon.Renglon4 = m.Get(\"direccion\")  ' España";
Debug.ShouldStop(512);
_renglon.setField ("Renglon4",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("direccion"))))));
 BA.debugLineNum = 75;BA.debugLine="Renglon.Renglon5 = m.Get(\"telefono\")  ' España";
Debug.ShouldStop(1024);
_renglon.setField ("Renglon5",BA.ObjectToString(_m.runMethod(false,"Get",(Object)(RemoteObject.createImmutable(("telefono"))))));
 BA.debugLineNum = 76;BA.debugLine="ListView1.AddTwoLines2(Renglon.Renglon1,Renglon.Renglon2 & \"  \"  & Renglon.Renglon3  & \" / \" &  Renglon.Renglon4 & \" / \" &  Renglon.Renglon5, Renglon)";
Debug.ShouldStop(2048);
listar.mostCurrent._listview1.runVoidMethod ("AddTwoLines2",(Object)(_renglon.getField(true,"Renglon1")),(Object)(RemoteObject.concat(_renglon.getField(true,"Renglon2"),RemoteObject.createImmutable("  "),_renglon.getField(true,"Renglon3"),RemoteObject.createImmutable(" / "),_renglon.getField(true,"Renglon4"),RemoteObject.createImmutable(" / "),_renglon.getField(true,"Renglon5"))),(Object)((_renglon)));
 BA.debugLineNum = 79;BA.debugLine="ListView1.TwoLinesLayout.Label.TextColor = Colors.Green 'color del primer item";
Debug.ShouldStop(16384);
listar.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextColor",listar.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 80;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.TextColor = Colors.white 'color del segundo item";
Debug.ShouldStop(32768);
listar.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").runMethod(true,"setTextColor",listar.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 82;BA.debugLine="ListView1.TwoLinesLayout.Label.TextSize = 10 'tamaño letra";
Debug.ShouldStop(131072);
listar.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 83;BA.debugLine="ListView1.TwoLinesLayout.SecondLabel.TextSize = 12 'tamaño letra";
Debug.ShouldStop(262144);
listar.mostCurrent._listview1.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 86;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2097152);
listar.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break;
case 1:
 BA.debugLineNum = 90;BA.debugLine="Dim l As List";
Debug.ShouldStop(33554432);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 91;BA.debugLine="l = parser.NextArray";
Debug.ShouldStop(67108864);
_l = _parser.runMethod(false,"NextArray");Debug.locals.put("l", _l);
 BA.debugLineNum = 92;BA.debugLine="If l.Size = 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_l.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 95;BA.debugLine="Dim m As Map";
Debug.ShouldStop(1073741824);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 96;BA.debugLine="m = l.Get(0)";
Debug.ShouldStop(-2147483648);
_m.setObject(_l.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 };
 break;
}
;
 BA.debugLineNum = 100;BA.debugLine="Response.Release";
Debug.ShouldStop(8);
_response.runVoidMethod ("Release");
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("ListView1_ItemClick (listar) ","listar",1,listar.mostCurrent.activityBA,listar.mostCurrent,104);
if (RapidSub.canDelegate("listview1_itemclick")) return listar.remoteMe.runUserSub(false, "listar","listview1_itemclick", _position, _value);
RemoteObject _renglon = RemoteObject.declareNull("b4a.example.listar._renglones");
RemoteObject _req = RemoteObject.declareNull("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");
RemoteObject _query = RemoteObject.createImmutable("");
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 104;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As Object)";
Debug.ShouldStop(128);
 BA.debugLineNum = 106;BA.debugLine="If IsBackgroundTaskRunning(hc, poblacion) Then ' Está ocupado en llamada anterior.";
Debug.ShouldStop(512);
if (listar.mostCurrent.__c.runMethod(true,"IsBackgroundTaskRunning",listar.mostCurrent.activityBA,(Object)((listar._hc)),(Object)(listar._poblacion)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(\"Espera hasta completar la llamada anterior.\", False)";
Debug.ShouldStop(1024);
listar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Espera hasta completar la llamada anterior.")),(Object)(listar.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 108;BA.debugLine="Return";
Debug.ShouldStop(2048);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 111;BA.debugLine="Dim Renglon As Renglones";
Debug.ShouldStop(16384);
_renglon = RemoteObject.createNew ("b4a.example.listar._renglones");Debug.locals.put("Renglon", _renglon);
 BA.debugLineNum = 112;BA.debugLine="Renglon = Value";
Debug.ShouldStop(32768);
_renglon = (_value);Debug.locals.put("Renglon", _renglon);
 BA.debugLineNum = 116;BA.debugLine="Dim req As HttpRequest";
Debug.ShouldStop(524288);
_req = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper");Debug.locals.put("req", _req);
 BA.debugLineNum = 117;BA.debugLine="Dim Query As String";
Debug.ShouldStop(1048576);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 118;BA.debugLine="Query=\"SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE ID='\" & Renglon.Renglon1 & \"'\"";
Debug.ShouldStop(2097152);
_query = RemoteObject.concat(RemoteObject.createImmutable("SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE ID='"),_renglon.getField(true,"Renglon1"),RemoteObject.createImmutable("'"));Debug.locals.put("Query", _query);
 BA.debugLineNum = 119;BA.debugLine="req.InitializePost2(\"http://192.168.241.2:81/paises.php\", Query.GetBytes(\"UTF8\"))";
Debug.ShouldStop(4194304);
_req.runVoidMethod ("InitializePost2",(Object)(BA.ObjectToString("http://192.168.241.2:81/paises.php")),(Object)(_query.runMethod(false,"getBytes",(Object)(BA.ObjectToString("UTF8")))));
 BA.debugLineNum = 120;BA.debugLine="hc.Execute(req, poblacion)  '''''''' En ResponseSuccess hará el Case de poblacion";
Debug.ShouldStop(8388608);
listar._hc.runVoidMethod ("Execute",listar.processBA,(Object)(_req),(Object)(listar._poblacion));
 BA.debugLineNum = 123;BA.debugLine="Msgbox(\"Nombre :  \" & Renglon.Renglon2&  Chr(13) & Chr(10)  &\"Apellidos :  \" &  Renglon.Renglon3 &  Chr(13) & Chr(10)  &\"Direccion :  \" &  Renglon.Renglon4&  Chr(13) & Chr(10)  &\"Telefono :  \" &  Renglon.Renglon5, \"Detalles del Usuario\")";
Debug.ShouldStop(67108864);
listar.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Nombre :  "),_renglon.getField(true,"Renglon2"),listar.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))),listar.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable("Apellidos :  "),_renglon.getField(true,"Renglon3"),listar.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))),listar.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable("Direccion :  "),_renglon.getField(true,"Renglon4"),listar.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))),listar.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable("Telefono :  "),_renglon.getField(true,"Renglon5"))),(Object)(BA.ObjectToString("Detalles del Usuario")),listar.mostCurrent.activityBA);
 BA.debugLineNum = 126;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim hc As HttpClient";
listar._hc = RemoteObject.createNew ("anywheresoftware.b4a.http.HttpClientWrapper");
 //BA.debugLineNum = 8;BA.debugLine="Dim paises, poblacion As Int";
listar._paises = RemoteObject.createImmutable(0);
listar._poblacion = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 9;BA.debugLine="paises = 1    ' Es la tarea 1";
listar._paises = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 10;BA.debugLine="poblacion = 2 ' Es la tarea 2";
listar._poblacion = BA.numberCast(int.class, 2);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}