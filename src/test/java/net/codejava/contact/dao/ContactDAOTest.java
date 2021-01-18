package net.codejava.contact.dao;

import net.codejava.contact.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

class ContactDAOTest {
    private DriverManagerDataSource dataSource;
    private ContactDAO dao;

    @BeforeEach
    void  setupBeforeEach(){
        dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/contactdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");

        dao=new ContactDAOImpl(dataSource);

    }

     @Test
     void  testSave(){

         Contact contact =new Contact("Mustafa Söyler","mstfylrr@gmail.com","Konya","538*********");
         int result=dao.save(contact);

         assertTrue(result > 0);


     }
     @Test
     void testUpdate(){
        Contact contact=new Contact(1,"Mustafa Söyler","mstfylrr123@gmail.com","Konya","538*********");
        int result=dao.update(contact);
        assertTrue(result > 0);

     }
     @Test
     void testGet(){
        Integer id=1;
        Contact contact = dao.get(id);
        if (contact != null){
            System.out.println(contact);
        }
        assertNotNull(contact);
     }
     @Test
     void  testDelete(){
        Integer id=2;
        int result= dao.delete(id);
        assertTrue(result>0);

     }
     @Test
     void testList(){
         List<Contact> listcontacts=dao.list();
         for (Contact acontact: listcontacts){
             System.out.println(acontact);
         }
         assertTrue(!listcontacts.isEmpty());
     }

    private void assertNotNull(Contact contact) {
    }

    private void assertTrue(boolean b) {
    }

}
