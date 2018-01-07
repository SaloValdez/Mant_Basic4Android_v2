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
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.


Dim id, nombre, apellido,direccion,telefono, datos As String
	Private txtApellido As EditText
	Private txtDireccion As EditText
	Private txtNombre As EditText
	Private txtTelefono As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	If FirstTime Then
		hc.Initialize("hc")
	End If
	
	
	Activity.LoadLayout("lay_insertar")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btnInsertar_Click
	nombre = txtNombre.Text
	apellido = txtApellido.Text
	direccion = txtDireccion.Text
	telefono = txtTelefono.Text

	Dim req As HttpRequest
	Dim Query As String
	Query="INSERT INTO usuario (nombre, apellido,direccion,telefono) VALUES ('" & nombre & "','" & apellido & "','" & direccion & "','" & telefono & "')"
	req.InitializePost2("http://192.168.241.2:81/paises.php", Query.GetBytes("UTF8"))
	hc.Execute(req, 1)
	
	
	txtNombre.Text=""
	txtApellido.Text=""
	txtDireccion.Text=""
	txtTelefono.Text=""
End Sub

Sub btnListar_Click
	StartActivity("listar")
	Activity.Finish	
	
	
End Sub


Sub hc_ResponseSuccess (Response As HttpResponse, tarea As Int)
	Dim resultString As String
	resultString = Response.GetString("UTF8")

	Msgbox("Los datos han sido almacenados", "Éxito de operación")
End Sub

Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, tarea As Int)
	Log("Error: " & Reason & ", StatusCode: " & StatusCode)
	If Response <> Null Then
	Log(Response.GetString("UTF8"))
	Response.Release
	End If
End Sub 
