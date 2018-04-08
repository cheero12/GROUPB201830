<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link rel="stylesheet" type="text/css" href="includes/form.css" />
</head>

<body>
<?php
	include('menu.php');
?>
<div id = "slideshow-container">
<form method ="post" action = "formprocess.php">
<br>
Given Name:<input type = "text" name ="givenname" size = "10"><br><br>
Family Name: <input type = "text" name ="familyname" size = "10"><br><br>
Model Name :<input type = "text" name = "modelname" size = "10"><br><br>
ISBN: <input type = "text" name = "isbn" size = "10"><br><br><br> 
Steps: <input type = "text" name = "steps" size = "10"><br><br> 
Page Number: <input type = "text" name = "pagenumber" size = "10"><br><br> 
 Video:<input type = "checkbox" value = "video" name = "type"><br><br>
Book:<input type = "checkbox" value = "book" name = "type"><br><br>
 Pdf:<input type = "checkbox" value = "pdf" name = "type"><br><br>
Paper:<select name = "paper">
				 <optgroup>
				 <option value = "square"> Square </option>
				 <option value = "round"> Round </option>
                 <option value = "rectangle"> Rectangle </option>
				 </optgroup><br>
		 
		      </select>   

Type:<select name = "type">
				 <optgroup>
				 <option value = "video"> Video </option>
				 <option value = "book"> Book </option>
                 <option value = "pdf"> Pdf </option>
				 </optgroup>
		 
	</select>	         
<br><br>

<input type = "submit">
<input type ="reset" name = "reset">
</form>
</div>
<footer>Your company name.</footer>
</div>


</body>
</html>
