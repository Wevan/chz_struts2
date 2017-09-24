package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChzDoAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        String chzrole = (String) ActionContext.getContext().getSession().get("chzrole");
        if (chzrole.equals("1")){
            return SUCCESS;
        }else {
            return LOGIN;
        }
    }
}
