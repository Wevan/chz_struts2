package action;

import Utils.JDBCUtil;
import bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;


/**
 * Created by Wean on 2017/9/11.
 */
public class ChzLoginAction extends ActionSupport {
    private User user;
    private String tip;
    private Connection conn = JDBCUtil.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public void validate() {
        String chzuname = getUser().getChzuname();
        String chzupass = getUser().getChzupwd();
        if (chzuname==null|| Objects.equals(chzuname, "")){
            addFieldError("unameerror","用户名不能为空！");
        }
        if (chzuname==null||chzupass.equals("")){
            addFieldError("upasserror","用户密码不能为空！");
        }

    }

    @Override
    public String execute() throws Exception {
        String chzuname = getUser().getChzuname();
        String chzupass = getUser().getChzupwd();
        System.out.println("a is "+chzuname+chzupass);
        ActionContext.getContext().getSession().put("chzuname", chzuname);
        String sql = "SELECT * FROM lender WHERE name=? AND password=?";
        ps = conn.prepareStatement(sql);

        ps.setString(1,chzuname);
        ps.setString(2,chzupass);

        rs = ps.executeQuery();
        if (rs.next()){

            System.out.println("1111111"+rs.getString("name"));
            return SUCCESS;

        }else {
            return ERROR;
        }
    }


    public String regist() throws Exception {
        ActionContext.getContext().getSession().put("chzuname", getUser().getChzuname());
        setTip(getUser().getRole());
        ActionContext.getContext().getSession().put("chztip", getTip());
        return SUCCESS;
    }
}
