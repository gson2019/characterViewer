package com.example.characterviewer.model


import com.google.gson.annotations.SerializedName

data class Meta(
    val attribution: Any,
    val blockgroup: Any,
    @SerializedName("created_date")
    val createdDate: Any,
    val description: String,
    val designer: Any,
    @SerializedName("dev_date")
    val devDate: Any,
    @SerializedName("dev_milestone")
    val devMilestone: String,
    val developer: List<Developer>,
    @SerializedName("example_query")
    val exampleQuery: String,
    val id: String,
    @SerializedName("is_stackexchange")
    val isStackexchange: Any,
    @SerializedName("js_callback_name")
    val jsCallbackName: String,
    @SerializedName("live_date")
    val liveDate: Any,
    val maintainer: Maintainer,
    val name: String,
    @SerializedName("perl_module")
    val perlModule: String,
    val producer: Any,
    @SerializedName("production_state")
    val productionState: String,
    val repo: String,
    @SerializedName("signal_from")
    val signalFrom: String,
    @SerializedName("src_domain")
    val srcDomain: String,
    @SerializedName("src_id")
    val srcId: Int,
    @SerializedName("src_name")
    val srcName: String,
    @SerializedName("src_options")
    val srcOptions: SrcOptions,
    @SerializedName("src_url")
    val srcUrl: Any,
    val status: String,
    val tab: String,
    val topic: List<String>,
    val unsafe: Int
)