package com.zhhl.library_frame.http

import okhttp3.Response

data class HttpDTO(
        var checkId: Int? = -1,
        var url: String? = null,
        var response: Response? = null,
        var content: String? = null,
        var errorPo: ErrorPo? = null
)

data class ErrorPo(
        var statusCode: Int? = -1
)