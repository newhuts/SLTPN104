  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_POST['nis']) && isset($_POST['nip'])) { 
    $nis = $_POST['nis'];
    $nip = $_POST['nip'];
    $kd_pel = $_POST['kd_pel'];
    $kd_kls = $_POST['kd_kls'];
    $nm_siswa = $_POST['nm_siswa'];
    $nilai = $_POST['nilai'];
    $ket = $_POST['ket'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO nilai(nis, nip, kd_pel, kd_kls, nm_siswa, nilai, ket) VALUES ('$nis', '$nip','$kd_pel', '$kd_kls', '$nm_siswa', '$nilai', '$ket') ");
    // check if row inserted or not
    if ($result) {
        $response["status"] = "input nilai $nm_siswa berhasil ";
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