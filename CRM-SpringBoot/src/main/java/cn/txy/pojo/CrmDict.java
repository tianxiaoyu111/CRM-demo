package cn.txy.pojo;

import java.io.Serializable;

public class CrmDict implements Serializable {
    private String dictId;

    private String dictTypeCode;

    private String dictTypeName;

    private String dictItemName;

    private String dictItemCode;

    private Integer dictSort;

    private String dictEnable;

    private String dictMemo;

    private static final long serialVersionUID = 1L;

    public CrmDict(String dictId, String dictTypeCode, String dictTypeName, String dictItemName, String dictItemCode, Integer dictSort, String dictEnable, String dictMemo) {
        this.dictId = dictId;
        this.dictTypeCode = dictTypeCode;
        this.dictTypeName = dictTypeName;
        this.dictItemName = dictItemName;
        this.dictItemCode = dictItemCode;
        this.dictSort = dictSort;
        this.dictEnable = dictEnable;
        this.dictMemo = dictMemo;
    }

    public CrmDict() {
        super();
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName == null ? null : dictTypeName.trim();
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName == null ? null : dictItemName.trim();
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode == null ? null : dictItemCode.trim();
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {
        this.dictEnable = dictEnable == null ? null : dictEnable.trim();
    }

    public String getDictMemo() {
        return dictMemo;
    }

    public void setDictMemo(String dictMemo) {
        this.dictMemo = dictMemo == null ? null : dictMemo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictId=").append(dictId);
        sb.append(", dictTypeCode=").append(dictTypeCode);
        sb.append(", dictTypeName=").append(dictTypeName);
        sb.append(", dictItemName=").append(dictItemName);
        sb.append(", dictItemCode=").append(dictItemCode);
        sb.append(", dictSort=").append(dictSort);
        sb.append(", dictEnable=").append(dictEnable);
        sb.append(", dictMemo=").append(dictMemo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}