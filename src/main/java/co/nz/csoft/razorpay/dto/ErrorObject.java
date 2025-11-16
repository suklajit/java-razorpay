package co.nz.csoft.razorpay.dto;

public class ErrorObject {
    private String type;
    private String code;
    private String description;
    private String origin;
    private String payload;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", origin='" + origin + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
