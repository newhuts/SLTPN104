  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_POST['kd_pel'])) { 
    $kd_pel = $_POST['kd_pel'];
    $hari = $_POST['hari'];
    $jam = $_POST['jam'];
    $kls = $_POST['kls'];
    $semester = $_POST['semester'];
    $nm_pel = $_POST['nm_pel'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO pelajaran(kd_pel, hari, jam, kls, semester, nm_pel) VALUES ('$kd_pel', '$hari','$jam', '$kls', '$semester', '$nm_pel') ");
    // check if row inserted or not
    if ($result) {
        $response["status"] = "input pelajaran $nm_pel berhasil ";
        $oke["d"] = $response;
        echo json_encode($oke);
    } else {
        $response["reason"] = "(1) oops! ada yang salah !";
        $oke["e"] = $response;
        echo json_encode($oke);
    }
} else {
    $response["reason"] = "(2) oops! ada yang salah !";
    $oke["e"] = $response;
    echo json_encode($oke);
}
?>