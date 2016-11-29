package entity;

import entity.Contract;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T11:16:57")
@StaticMetamodel(ContractValue.class)
public class ContractValue_ { 

    public static volatile SingularAttribute<ContractValue, String> dsAmountContractValue;
    public static volatile SingularAttribute<ContractValue, String> dsPeriodicity;
    public static volatile SingularAttribute<ContractValue, Contract> contract;
    public static volatile SingularAttribute<ContractValue, String> vlMonthlyUSD;
    public static volatile SingularAttribute<ContractValue, String> dsCoin;
    public static volatile SingularAttribute<ContractValue, Long> idContractValue;

}