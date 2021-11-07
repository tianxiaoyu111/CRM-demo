package cn.txy.dto;

/**
 * 多条件查询请求的参数封装
 */
public class CustomerQuery {
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    private Integer size = 10;
    private Integer page = 1;

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", size='" + size + '\'' +
                ", page='" + page + '\'' +
                '}';
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        // 如果请求的size参数为null, 则什么也不做, 用默认值10.
        if (size != null) {
            this.size = size;
        }
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        // 如果请求的page参数为null, 则什么也不做, 用默认值1.
        if (page != null) {
            this.page = page;
        }
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }
}
