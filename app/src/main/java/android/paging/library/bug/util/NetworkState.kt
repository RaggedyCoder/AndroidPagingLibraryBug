package android.paging.library.bug.util

class NetworkState private constructor(
    val status: Status,
    val t: Throwable? = null
) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val REFRESHING = NetworkState(Status.REFRESH)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(t: Throwable) = NetworkState(Status.FAILED, t)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NetworkState
        if (status != Status.FAILED) {
            return status == other.status
        } else {
            if (status != other.status) return false
            if (t != other.t) return false
            return true
        }
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + (t?.hashCode() ?: 0)
        return result
    }
}
