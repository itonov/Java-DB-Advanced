package soft_uni.products_shop.models.dto.binding.users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserBindingModelXml {

    @XmlElement(name = "user")
    private List<UserBindingModel> users;

    public UserBindingModelXml() {
    }

    public List<UserBindingModel> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserBindingModel> users) {
        this.users = users;
    }
}
