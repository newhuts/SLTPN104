  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_POST['kd_kls']) && isset($_POST['nip'])) { 
    $kd_kls = $_POST['kd_kls'];
    $nip = $_POST['nip'];
    $nm_kls = $_POST['nm_kls'];

    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO kelas(kd_kls, nip, nm_kls) VALUES ('$kd_kls', '$nip','$nm_kls') ");
    // check if row inserted or not
    if ($result) {
        $response["status"] = "input kelas $nm_kls berhasil ";
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