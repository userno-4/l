Roman

<html>
    <head>
        <title>Roman converter</title>
    </head>
    <body>
        <form method="post">
             * Enter Roman number:
            <input type="text" name="roman" placeholder="Enter a number">
            <button type="submit" name="convert_roman">Convert to Decimal</button>
        </form>

        <form method="post">
             * Enter Decimal number:
            <input type="number" name="decimal" placeholder="Enter a number (1-3999)">
            <button type="submit" name="convert_decimal">Convert to Roman</button>
        </form>

        <?php 
            // Roman to Numeric conversion (your existing code)
            if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["convert_roman"])){
                $roman = strtoupper($_POST["roman"]);
                if(!preg_match("/^[IVXLCDM]+$/", $roman)){
                    echo "Invalid Roman numeral";
                    exit();
                }

                $values = array(
                    'I' => 1,
                    'V' => 5,
                    'X' => 10,
                    'L' => 50,
                    'C' => 100,
                    'D' => 500,
                    'M' => 1000
                );
                $decimal = 0;
                $length = strlen($roman);

                for($i = 0; $i < $length; $i++){
                    $current = $values[$roman[$i]];

                    if($i + 1 < $length){
                        $next = $values[$roman[$i + 1]];
                        if($current < $next){
                            $decimal -= $current;
                        } else {
                            $decimal += $current;
                        }
                    } else {
                        $decimal += $current;
                    }
                }
                echo "<h3>Decimal value: " . $decimal."</h3>";
            }
            
            // Numeric to Roman conversion (new addition)
            if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["convert_decimal"])){
                $number = intval($_POST["decimal"]);
                
                if($number < 1 || $number > 3999){
                    echo "Please enter a number between 1 and 3999";
                    exit();
                }
                
                $romanNumerals = array(
                    'M' => 1000,
                    'CM' => 900,
                    'D' => 500,
                    'CD' => 400,
                    'C' => 100,
                    'XC' => 90,
                    'L' => 50,
                    'XL' => 40,
                    'X' => 10,
                    'IX' => 9,
                    'V' => 5,
                    'IV' => 4,
                    'I' => 1
                );
                
                $roman = '';
                foreach($romanNumerals as $romanChar => $value){
                    while($number >= $value){
                        $roman .= $romanChar;
                        $number -= $value;
                    }
                }
                echo "<h3>Roman numeral: " . $roman."</h3>";
            }
        ?>
            
    </body>
</html>

ID

<html>
	<head>
			<title></title>
	</head>
	<body>
		<h2>Date of birth and Gender from the NIC Number</h2>
		<form method="post" action="">
			<label>NIC Number: </label>
			<input type="text" name="nic" required>
			<br><br>
			<input type="submit" value="SUBMIT">
			<input type="reset" value="RESET">
		</form>
		
		<?php
			if ($_SERVER["REQUEST_METHOD"] == "POST") {
				$nic = trim($_POST['nic']);
				$year = "";
				$dayValue = 0;
				$isValid = true;

				if (strlen($nic) == 10) { 
					echo "This is an old NIC Number.";
					
					$year = "19" . substr($nic, 0, 2);
					$dayValue = (int)substr($nic, 2, 3);
					
				} elseif (strlen($nic) == 12) { 
					echo "This is a new NIC Number.";
					
					$year = substr($nic, 0, 4);
					$dayValue = (int)substr($nic, 4, 3);
				
				} else {
					echo "Invalid NIC Length....!";
					$isValid = false;
				}

				if ($isValid) {
					
					$gender = "Male";
					if ($dayValue > 500) {
						$gender = "Female";
						$dayValue -= 500;
					}

					$monthDays = [ 
					"January" => 31,
					"February" => 29,
					"March" => 31,
					"April" => 30,
					"May" => 31, 
					"June" => 30, 
					"July" => 31, 
					"August" => 31,
					"September" => 30,
					"October" => 31,
					"November" => 30,
					"December" => 31
					];

					$currentMonth = "";
					$birthDay = 0;

					foreach ($monthDays as $month => $days) {
						if ($dayValue <= $days) {
							$currentMonth = $month;
							$birthDay = $dayValue;
							break;
						}
						$dayValue -= $days;
					}
					echo "<br><br>";
					echo "Gender : " . $gender . "<br>";
					echo "Year : " . $year . "<br>";
					echo "Month : " . $currentmonth . "<br>";
					echo "Day : " . $birthday. "<br><br>";
					echo "<b>Date of Birth: ".$birthday." ".$currentmonth." ".$year;
				}
			}
			?>
	</body>
</html>

FORM

<html>
	<head>
		<title>Form Validation</title>
		<style>
			.error {color: red;}
			.form {
				max-width: 600px;
				margin: auto;
				background: white;
				padding: 20px;
				border: 1px solid black;
			}
			input[type=submit]{
				color:white;
				background-color:green;
			}
			input[type=reset]{
				color:white;
				background-color:red;
			}
			input[type=text]{
				padding:5px;
				margin: 2px;
			}

		</style>
	</head>
	<body>
		<?php
			if($_SERVER["REQUEST_METHOD"] == "POST"){
				$name = $_POST["name"];
				$email = $_POST["email"];
				$website = $_POST["website"];
				$comment = $_POST["comment"];
				$gender = $_POST["gender"];
				
				if(empty($name) || !preg_match("/^[a-zA-Z ]*$/",$name)){
					echo "<p class='error'>Invalid Name</p>";
				}
				if(empty($email) || !filter_var($email, FILTER_VALIDATE_EMAIL)){
					echo "<p class='error'>Invalid email</p>";
				}
				if(!empty($website) && !filter_var($website, FILTER_VALIDATE_URL)){
					echo "<p class='error'>Invalid Website url</p>";
				}
				if(empty($gender)){
					echo "<p class='error'>Gender is required</p>";
				}
				echo "<br>Form Submitted Sucessfully.";
			}else{
			?>
				
				<form class="form" method="post" action="">
				<span class="error">* required field</span><br><br>
				Name:<input type="text" name="name"><br>
				
				Emai:<input type="text" name="email"><br>
				
				Website: <input type="text" name="website"><br>
				
				Comment:<br>
				<textarea name="comment" rows="5" cols="40"></textarea><br>
				
				Gender:
				<input type="radio" name="gender" value="Male">Male
				<input type="radio" name="gender" value="Female">Female
				<input type="radio" name="gender" value="others">Others
				<br><br>
				
				<input type="submit" value="SUBMIT">
				<input type="reset" value="RESET">
				
				</form>
			<?php
			}
		?>
	</body>
</html>