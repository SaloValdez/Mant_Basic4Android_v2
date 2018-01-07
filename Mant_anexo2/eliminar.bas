Type=Activity
Version=4
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
' De los tutoriales de b4a

' Adaptado a local por Juan Antonio Villalpando
' juana1991@yahoo.com 

Sub Process_Globals
Dim hc As HttpClient
Dim paises, poblacion, bus As Int
paises = 1    ' Es la tarea 1
poblacion = 2 ' Es la tarea 2
bus = 3 ' Es la tarea 3 PARA BUSCAR, CÓDIGO JUAN ANTONIO ------
End Sub

Sub Globals
' Renglones puede contener dos renglones:
' Renglon1 (ES) 
' Renglon2 (España)
'Type Renglones (Renglon1 As String, Renglon2 As String)

Dim ListView1 As ListView

Dim borraID As String ' PARA BORRAR, CÓDIGO JUAN ANTONIO *********
	Private btnBuscar As Button
	Private btnEliminar As Button
	Private txtBuscar As EditText
	Private txtId As Label
	Private txtNombres As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
If FirstTime Then
hc.Initialize("hc")
End If
Activity.LoadLayout("lay_eliminar")
Buscar_lista_de_paises
End Sub

Sub Buscar_lista_de_paises
ProgressDialogShow("Buscando lista de países.")

Dim req As HttpRequest
Dim Query As String
Query="SELECT nombre,apellido,direccion,telefono, id FROM usuario ORDER BY ID"
' req.InitializePost2("http://192.168.1.3/paises.php", Query.GetBytes("UTF8"))
req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
hc.Execute(req, paises) '''''''' En ResponseSuccess hará el Case de paises
End Sub

' Esta es la Respuesta de la orden hc.Execute
Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)
Dim res As String
res = Response.GetString("UTF8")
Log("Respuesta del servidor: " & res)
'res =  [{"name":"Argentina","id":"AR"},.... hasta ....,{"name":"Venezuela","id":"VE"}]
Dim parser As JSONParser
parser.Initialize(res)

Select tarea

' ************* PAISES *****************
Case paises
' Añade paises la ListView1
Dim countries As List
countries.Initialize
countries = parser.NextArray
For i = 0 To countries.Size - 1
Dim m As Map
m = countries.Get(i)
Dim Renglon As Renglones
		Renglon.Renglon1 = m.Get("id")      ' ES
		Renglon.Renglon2 = m.Get("nombre")  ' España
		Renglon.Renglon3 = m.Get("apellido")  ' España
		Renglon.Renglon4 = m.Get("direccion")  ' España
		Renglon.Renglon5 = m.Get("telefono")  ' España
ListView1.AddTwoLines2(Renglon.Renglon1, Renglon.Renglon2 & "   " &  Renglon.Renglon3 , Renglon)
Next
ProgressDialogHide

' ************* POBLACION **************
Case poblacion
Dim l As List
l = parser.NextArray
If l.Size = 0 Then
txtId.Text = "N/A"
Else
Dim m As Map
m = l.Get(0)
txtId.Text = m.Get("id")
End If


' ************* BUSCAR, CÓDIGO JUAN ANTONIO *****------
Case bus
Dim l As List
l = parser.NextArray
If l.Size = 0 Then
txtId.Text = "N/A"
Else
Dim m As Map
m = l.Get(0)
txtId.Text = m.Get("id")
txtNombres.Text =  m.Get("nombre")
End If
End Select

Response.Release
End Sub

' Cuando pulsa en el ListView, busca en la BD del Servidor la población
Sub ListView1_ItemClick (Position As Int, Value As Object)

If IsBackgroundTaskRunning(hc, poblacion) Then ' Está ocupado en llamada anterior.
ToastMessageShow("Espera hasta completar la llamada anterior.", False)
Return
End If

Dim Renglon As Renglones
Renglon = Value
txtNombres.Text = Renglon.Renglon2 ' España
borraID = Renglon.Renglon1  ' PARA BORRAR, CÓDIGO JUAN ANTONIO *******
txtId.Text = Renglon.Renglon1

Dim req As HttpRequest
Dim Query As String
Query="SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE id='" & Renglon.Renglon1 & "'"
' req.InitializePost2("http://192.168.1.3/paises.php", Query.GetBytes("UTF8"))
req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
hc.Execute(req, poblacion)  '''''''' En ResponseSuccess hará el Case de poblacion
End Sub


' Error en la conexión con la Base de datos.
Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)
Log("Error: " & Reason & ", StatusCode: " & StatusCode)
If Response <> Null Then
Log(Response.GetString("UTF8"))
Response.Release
End If
ProgressDialogHide
End Sub


Sub btnEliminar_Click

	Dim req As HttpRequest
Dim Query As String

Dim ids As String

ids = txtId.Text

Query="DELETE FROM usuario  WHERE id='" & ids & "'"
' req.InitializePost2("http://192.168.1.3/paises.php", Query.GetBytes("UTF8"))
req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
hc.Execute(req, 4) ' ------- He cambiado esto, 4 es una tarea que no existe en Select

ListView1.Clear
Buscar_lista_de_paises
txtId.Text=""
txtNombres.Text="" 
End Sub

Sub btnBuscar_Click
	Dim req As HttpRequest
Dim Query As String
Dim busca As String
busca = txtBuscar.Text

Query="SELECT * FROM usuario WHERE nombre LIKE '" & busca & "'"
' req.InitializePost2("http://192.168.1.3/paises.php", Query.GetBytes("UTF8"))
req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
hc.Execute(req, bus)
End Sub
Sub btnIrListar_Click
	StartActivity("listar")
	Activity.Finish	
End Sub