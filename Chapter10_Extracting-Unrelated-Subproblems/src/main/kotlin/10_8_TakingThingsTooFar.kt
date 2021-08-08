import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

// × 小さな関数を作りすぎたことで逆に読みにくくなってしまっている
class User(
    private val name: String,
    private val password: String,
) {
    private fun information() = "username:${this.name}, password:${this.password}"
    fun url() = "https://example.com/?user_info=${encryptUrl(information())}"
}

fun encryptUrl(url: String): String {
    val encryptedBytes = encrypt(url)
    return String(encryptedBytes)
}

fun encrypt(data: String): ByteArray {
    val key = SecretKeySpec("0123456789012345".toByteArray(), "AES")
    val encryptor = Cipher.getInstance("AES/CBC/PKCS5Padding")
    encryptor.init(Cipher.ENCRYPT_MODE, key)

    return encryptor.doFinal(data.toByteArray())
}
