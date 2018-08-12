package com.imooc.demo.vo;

public class CommunicationAjaxInVo {

    /**
     * /**
     *          * 请求报文：
     *          * fwServiceId
     *          * fwTranId
     *          * jsonData
     *          * type - AJAX_METHOD - no
     *          * headers - no
     *          * timeout - AJAX_TIMEOUT - no
     *          * success - no
     *          * failure - no
     *          *
     */

    /**
     * fwServiceId - 服务类型
     * - "simpleTransaction"
     * - "database"
     * - "getServerTime" ...
     */
    private String fwServiceId;

    /**
     * fwTranId - 交易码
     * - A16280001
     */
    private String fwTranId;

    /**
     * jsonData - 请求数据
     */
    private String jsonData;

    /**
     * type - 请求类型
     */
    private String type;

    /**
     * dataType - 数据类型
     * - "json"
     */
    private String dataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFwServiceId() {
        return fwServiceId;
    }

    public void setFwServiceId(String fwServiceId) {
        this.fwServiceId = fwServiceId;
    }

    public String getFwTranId() {
        return fwTranId;
    }

    public void setFwTranId(String fwTranId) {
        this.fwTranId = fwTranId;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
