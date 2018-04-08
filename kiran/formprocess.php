<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
<?php
$givenname =$_POST["givenname"];
$familyname=$_POST["familyname"];
$modelname =$_POST["modelname"];
$isbn = $_POST["isbn"];
$steps =$_POST["steps"];
$pagenumber =$_POST["pagenumber"];
$paper =$_POST["paper"];
$type =$_POST["type"];

echo "My givenname is ".$givenname;echo "<br>";
echo "My Family name is ".$familyname; echo "<br>";

echo "My model name ".$modelname;echo "<br>";
echo "ISBN ".$isbn;echo "<br>";

echo "The steps included ".$steps;echo "<br>";
echo "Pagenumber is ".$pagenumber;echo "<br>";

if (isset($_POST['video'])) {
				echo "my file type is video<br>";
			}
		if (isset($_POST['book'])) {
				echo "my file type is book<br>";
			}
		if (isset($_POST['pdf'])) {
			echo "my file type is pdf<br>";
			}

       
		
		
echo "my paper type ".$paper; echo "<br>";
echo "my file  type ".$type; echo "<br>";
        
		
?>		


</body>
</html>