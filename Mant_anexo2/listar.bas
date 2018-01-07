Type=Activity
Version=4
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	Dim hc As HttpClient
	Dim paises, poblacion As Int
	paises = 1    ' Es la tarea 1
	poblacion = 2 ' Es la tarea 2
End Sub

Sub Globals
	' Renglones puede contener dos renglones:
	' Renglon1 (id) 
	' Renglon2 (nombre)
	Type Renglones (Renglon1 As String, Renglon2 As String,Renglon3 As String,Renglon4 As String,Renglon5 As String)
	'Dim Label1, Label2 As Label
	Dim ListView1 As ListView

	Private btnPrincipal As Button
	Private btnInsertar As Button


End Sub

Sub Activity_Create(FirstTime As Boolean)
	If FirstTime Then
	hc.Initialize("hc")
	End If
	Buscar_lista_de_paises
	
	Activity.LoadLayout("lay_listar")

End Sub

Sub Buscar_lista_de_paises
	ProgressDialogShow("Buscando lista de países.")

	Dim req As HttpRequest
	Dim Query As String
	Query="SELECT id,nombre,apellido,direccion,telefono FROM usuario ORDER BY id"
	req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
	hc.Execute(req, paises) '''''''' En ResponseSuccess hará el Case de paises

	
End Sub


' Esta es la Respuesta de la orden hc.Execute
Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)
	Dim res As String
	res = Response.GetString("UTF8")
	Log("Respuesta del servidor: " & res)
	'res =  [{"nombre":"Argentina","id":"AR"},.... hasta ....,{"nombre":"Venezuela","id":"VE"}]
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
		ListView1.AddTwoLines2(Renglon.Renglon1,Renglon.Renglon2 & "  "  & Renglon.Renglon3  & " / " &  Renglon.Renglon4 & " / " &  Renglon.Renglon5, Renglon)
		'ListView1.TwoLinesAndBitmap("COLOMBIA","COL",LoadBitmap(File.DirAssets,"Col.gif"))
		
		ListView1.TwoLinesLayout.Label.TextColor = Colors.Green 'color del primer item
		ListView1.TwoLinesLayout.SecondLabel.TextColor = Colors.white 'color del segundo item
		
		ListView1.TwoLinesLayout.Label.TextSize = 10 'tamaño letra
		ListView1.TwoLinesLayout.SecondLabel.TextSize = 12 'tamaño letra
		
	Next
	ProgressDialogHide

	' ************* POBLACION **************
	Case poblacion
		Dim l As List
		l = parser.NextArray
		If l.Size = 0 Then
			'Label1.Text = "N/A"
		Else
			Dim m As Map
			m = l.Get(0)
			'Label1.Text = m.Get("id") 'FORMATO NUMERO (NumberFormat2(m.Get("poblacion"),0, 0, 0, True) & ".000")
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
	'Label2.Text = Renglon.Renglon2 ' nombre
	'Label1.Text = "Conectando con el servidor..."

	Dim req As HttpRequest
	Dim Query As String
	Query="SELECT id,nombre,apellido,direccion,telefono FROM usuario WHERE ID='" & Renglon.Renglon1 & "'"
	req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
	hc.Execute(req, poblacion)  '''''''' En ResponseSuccess hará el Case de poblacion
	
	'Detalles en MSBOX
	Msgbox("Nombre :  " & Renglon.Renglon2&  Chr(13) & Chr(10)  &"Apellidos :  " &  Renglon.Renglon3 &  Chr(13) & Chr(10)  &"Direccion :  " &  Renglon.Renglon4&  Chr(13) & Chr(10)  &"Telefono :  " &  Renglon.Renglon5, "Detalles del Usuario") 
	
	
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

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btnPrincipal_Click
	StartActivity("Main")
	Activity.Finish	
End Sub

Sub btnInsertar_Click
	StartActivity("insertar")
	
	Activity.Finish	
End Sub
Sub btnIrEliminar_Click
	StartActivity("eliminar")
	Activity.Finish	
End Sub
Sub btnActualizar_Click
	StartActivity("Actualizar")
	Activity.Finish	
End Sub