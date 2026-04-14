class Client {
    public int id;
    public String name;
    public String serviceType;
    public String arrivalTime;
    public boolean served;

    public Client() {
    }
    public Client(int id, String name, String serviceType, String arrivalTime, boolean served) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.arrivalTime = arrivalTime;
        this.served = served;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public boolean isServed() {
        return served;
    }
    public void setServed(boolean served) {
        this.served = served;
    }
    
    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", serviceType=" + serviceType + ", arrivalTime=" + arrivalTime
                + ", served=" + served + "]";
    }
}