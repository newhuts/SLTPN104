  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_POST['nip']) && isset($_POST['nm_guru'])) { 
    $nip = $_POST['nip'];
    $nm_guru = $_POST['nm_guru'];
    $jns_klmn_guru = $_POST['jns_klmn_guru'];
    $temp_lhr_guru = $_POST['temp_lhr_guru'];
    $tgl_lhr_guru = $_POST['tgl_lhr_guru'];
    $almt_guru = $_POST['almt_guru'];
    $agm_guru = $_POST['agm_guru'];
    $status_peg = $_POST['status_peg'];
    $thn_masuk = $_POST['thn_masuk'];
    $tgs_mgjr_mp = $_POST['tgs_mgjr_mp'];
    $tlp_guru = $_POST['tlp_guru'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    $result = mysql_query("UPDATE guru SET nm_guru = '$nm_guru', jns_klmn_guru = '$jns_klmn_guru', temp_lhr_guru = '$temp_lhr_guru', tgl_lhr_guru = '$tgl_lhr_guru', almt_guru = '$almt_guru', agm_guru = '$agm_guru', status_peg = '$status_peg', thn_masuk = '$thn_masuk', tgs_mgjr_mp = '$tgs_mgjr_mp', tlp_guru = '$tlp_guru' WHERE nip = '$nip' ");
    // check if row inserted or not
    if ($result) {
        $response["status"] = "edit guru $nm_guru berhasil ";
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