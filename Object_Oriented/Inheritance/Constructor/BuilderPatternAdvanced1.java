public class Product {

    //商品要包含以下屬性
    private int serialNumber;    //流水號(int)(自動產生)
    private String name;//名稱(String)
    private int price; //價格(int)
    private String sort;//分類(String)
    private String company;//生產公司(String)
    private boolean continued;//上下架(boolean)
    private int resposity;//庫存量(int)
    public static class Builder{
        private String name;
        private int price; //價格(int)
        private String sort;//分類(String)
        private String company;//生產公司(String)
        private boolean continued;//上下架(boolean)
        private int resposity;//庫存量(int)

        public Builder setName(String name){
            this.name=name;
            return this;
        }
        public Builder setPrice(int price){
            this.price=price;
            return this;
        }

        public Builder setSort(String sort){
            this.sort=sort;
            return this;
        }

        public Builder setCompany(String company){
            this.company=company;
            return this;
        }

        public Builder setContinued(boolean continued){
            this.continued=continued;
            return this;
        }
        public Builder setResposity(int resposity){
            this.resposity=resposity;
            return this;
        }

        public Product gen(){
            Product pd=new Product();
            pd.setPrice(price);
            pd.setName(name);
            pd.setSort(sort);
            pd.setCompany(company);
            pd.setContinued(continued);
            pd.setResposity(resposity);
            return pd;
        }
    }
    /* 參數會超過五個以上,不好的寫法
    private Product(String name,int price,String sort,String company,boolean continued,int resposity) {
        setName(name);//名稱(String)
        setPrice(price);//價格(int)
        setSort(sort);//分類(String)
        setCompany(company);//生產公司(String)
        setContinued(continued);//上下架(boolean)
        setResposity(resposity);//庫存量(int)
    }*/


    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerial_number(int serial_number) {
        this.serialNumber = serial_number;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    private void setSort(String sort) {
        this.sort = sort;
    }

    public String getCompany() {
        return company;
    }

    private void setCompany(String productionCompany) {
        this.company = productionCompany;
    }

    public boolean isContinued() {
        return continued;
    }

    private void setContinued(boolean isContinued) {
        this.continued = isContinued;
    }

    public int getResposity() {
        return resposity;
    }

    private void setResposity(int resposity) {
        this.resposity = resposity;
    }
