  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_POST['id_absen'])) { 
    $id_absen = $_POST['id_absen'];
    $tgl_msk = $_POST['tgl_msk'];
    $jam_msk = $_POST['jam_msk'];
    $jam_klr = $_POST['jam_klr'];
    $status = $_POST['status'];
    $ket_absen = $_POST['ket_absen'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO absensi(id_absen, tgl_msk, jam_msk, jam_klr, status, ket_absen) VALUES ('$id_absen', '$tgl_msk','$jam_msk', '$jam_klr', '$status', '$ket_absen') ");
    // check if row inserted or not
    if ($result) {
        $response["status"] = "input absensi $id_absen berhasil ";
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