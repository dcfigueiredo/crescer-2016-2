package entity;

import entity.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T11:16:57")
@StaticMetamodel(Contract.class)
public class Contract_ { 

    public static volatile SingularAttribute<Contract, String> nmContract;
    public static volatile SingularAttribute<Contract, String> dsState;
    public static volatile SingularAttribute<Contract, Long> idContract;
    public static volatile SingularAttribute<Contract, String> dsDescription;
    public static volatile SingularAttribute<Contract, Client> client;
    public static volatile SingularAttribute<Contract, String> dsWebSite;

}