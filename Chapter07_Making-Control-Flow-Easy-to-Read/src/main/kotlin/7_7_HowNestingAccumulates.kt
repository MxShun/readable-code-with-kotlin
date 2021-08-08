@file:Suppress("ReturnCount")

const val SUCCESS: String = "Success"

fun reply(userResult: String, permissionResult: String, reply: Reply) {
    // ✕ネストが深く、自分がどの条件ブロックにいるのかを常に確認する必要がある
    if (userResult == SUCCESS) {
        if (permissionResult != SUCCESS) {
            reply.writeErrors("error reading permissions")
            reply.done()
            return
        }
        reply.writeErrors("")
    } else {
        reply.writeErrors(userResult)
    }
    reply.done()


    // 〇ネストが浅く保守も楽
    if (userResult != SUCCESS) {
        reply.writeErrors(userResult)
        reply.done()
        return
    }
    if (permissionResult != SUCCESS) {
        reply.writeErrors(permissionResult)
        reply.done()
        return
    }
    reply.writeErrors("")
    reply.done()
}

class Reply {
    fun writeErrors(message: String) {}
    fun done() {}
}
