package com.example.fydemo.dao;

import com.example.fydemo.conf.JdialectsConfig;
import com.example.fydemo.conf.SourceConfig;
import com.example.fydemo.entity.ProduceClass;
import com.github.drinkjava2.jdialects.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class ProduceClassDaoImpl implements ProduceClassDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(ProduceClass produceClass) {

        return jdbcTemplate.update("insert  into HS_PRODUCE_CLASS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                produceClass.getID(), produceClass.getCODE(), produceClass.getR_DATE(), produceClass.getCLASS(), produceClass.getR_TIME(),
                produceClass.getDATAVALUE1(), produceClass.getDATAVALUE2(), produceClass.getDECIDE(), produceClass.getTYPE(),
                produceClass.getPROPERTY(), produceClass.getREPORT_NAME(), produceClass.getCREATE_BY(), produceClass.getCREATE_TIME(),
                produceClass.getMODIFY_BY(), produceClass.getMODIFY_TIME());
    }

    @Override
    public int delete(String Code) {
        return jdbcTemplate.update("delete from HS_PRODUCE_CLASS  WHERE Code=?", Code);
    }

    @Override
    public List<ProduceClass> find(String Code) {
        List<ProduceClass> classList = jdbcTemplate.query("SELECT  * FROM  HS_PRODUCE_CLASS  WHERE Code=?", new Object[]{Code}, new BeanPropertyRowMapper(ProduceClass.class));
        if (classList.size() > 0 && classList != null) {
            return classList;
        } else {
            return null;
        }

    }

    @Override
    public int modify(String CLASS, String CODE) {
        return jdbcTemplate.update("UPDATE HS_PRODUCE_CLASS h SET h.CLASS =? WHERE h.Code =?", CLASS, CODE);
    }

    @Override
    public List<ProduceClass> findall() {
        System.out.println("1");
        List<ProduceClass> list = jdbcTemplate.query("SELECT  * FROM  HS_PRODUCE_CLASS", new MyRowMapper());
        System.out.println("2");

        if (list.size() > 0) {
            System.out.println("3");

            return list;
        } else {
            System.out.println("4");
            return null;

        }
    }

    @Autowired
    SourceConfig sourceConfig;
    @Override
    public List<ProduceClass> paging() {
        DataSource dataSource = sourceConfig.primaryDataSource();
        Dialect d = Dialect.guessDialect(dataSource);
        String result = d.pagin(1, 5, "select * from HS_PRODUCE_CLASS "); //创建分页SQL
        System.out.println(result);
        List<ProduceClass> list = jdbcTemplate.query(result, new MyRowMapper());
        return list;
    }


}

/**
 * private Double DECIDE ;
 * private String TYPE;
 * private String  PROPERTY;
 * private String  REPORT_NAME;
 * private String CREATE_BY ;
 * private Date CREATE_TIME;
 * private String MODIFY_BY;
 * private Date  MODIFY_TIME;
 */
class MyRowMapper implements RowMapper<ProduceClass> {

    @Override
    public ProduceClass mapRow(ResultSet arg0, int arg1) throws SQLException {
        ProduceClass produceClass = new ProduceClass();
        produceClass.setID(arg0.getString("ID"));
        produceClass.setCODE(arg0.getString("CODE"));
        produceClass.setR_DATE(arg0.getDate("R_DATE"));
        produceClass.setCLASS(arg0.getString("CLASS"));
        produceClass.setR_TIME(arg0.getString("R_TIME"));
        produceClass.setDATAVALUE1(arg0.getDouble("DATAVALUE1"));
        produceClass.setDATAVALUE2(arg0.getDouble("DATAVALUE2"));
        produceClass.setDECIDE(arg0.getDouble("DECIDE"));
        produceClass.setTYPE(arg0.getString("TYPE"));
        produceClass.setPROPERTY(arg0.getString("PROPERTY"));
        produceClass.setREPORT_NAME(arg0.getString("REPORT_NAME"));
        produceClass.setCREATE_BY(arg0.getString("CREATE_BY"));
        produceClass.setCREATE_TIME(arg0.getDate("CREATE_TIME"));
        produceClass.setMODIFY_BY(arg0.getString("MODIFY_BY"));
        produceClass.setMODIFY_TIME(arg0.getDate("MODIFY_TIME"));


        return produceClass;
    }

}



