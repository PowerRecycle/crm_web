package com.crazycode;

import com.crazycode.mapper.ProductMapper;
import com.crazycode.mapper.RoleMapper;
import com.crazycode.mapper.UsersMapper;
import com.crazycode.pojo.*;
import com.crazycode.service.*;
import com.crazycode.util.MD5Util;
import lombok.AllArgsConstructor;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.shiro.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CrmWebApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UsersRoleService usersRoleService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Analyzer analyzer;
    @Autowired
    private Directory directory;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IndexWriter indexWriter;

    @Test
    void testCreateIndex() throws Exception {
// 从数据库中读取数据
        List<Product> products = productMapper.selectAll();
        //把数据写到索引库中
        //Document文档的集合,一条记录就封装成一个Document对象
        List<Document> productList = new ArrayList<>();
        for (Product product : products) {
            Document document = new Document();
            //获取每条记录中的数据
            String id = product.getId();
            String cityName = product.getCityName();
            String departureTime = product.getDepartureTime();
            String productDesc = product.getProductDesc();
            String productName = product.getProductName();
            String productNum = product.getProductNum();
            Double productPrice = product.getProductPrice();
            Long productStatus = product.getProductStatus();
            document.add(new StringField("id", id, Field.Store.YES));
            document.add(new TextField("cityName", cityName, Field.Store.YES));
            document.add(new StringField("departureTime", departureTime, Field.Store.YES));
            document.add(new TextField("productDesc", productDesc, Field.Store.YES));
            document.add(new TextField("productName", productName, Field.Store.YES));
            document.add(new TextField("productNum", productNum, Field.Store.YES));
            document.add(new TextField("productPrice", productPrice.toString(), Field.Store.YES));
            document.add(new StringField("productStatus", productStatus.toString(), Field.Store.YES));
            productList.add(document);
        }
        //把所有的文档写到索引库
        indexWriter.addDocuments(productList);
        indexWriter.commit();
    }

    @Test
    void testIndex() throws Exception {
        String queryString = "西藏";

        //指定索引库的路径
        // FSDirectory directory = FSDirectory.open(new File("D:\\index").toPath());
        //创建索引库写入对象,并告知写到哪里,使用指定的配置(分析器,默认使用的是标准分析器StandardAnalyzer)
        // IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));
        //以读的方式打开索引库
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建索引库查询器对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        QueryParser queryParser = new QueryParser("productName", analyzer);
        Query query = queryParser.parse(queryString);
        TopDocs topDocs = indexSearcher.search(query, 20);
        System.out.println(topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println(scoreDoc);
        }
        // ArrayList<Product> products = new ArrayList<>();
    }

    @Test
    void contextLoads10() throws Exception {
        System.out.println((new Timestamp(System.currentTimeMillis())).toString());

    }

    @Test
    void contextLoads9() throws Exception {
        Users user = usersMapper.findAllUsersAndRolesAndPermissionsByUserId("a151fe9f-9f1e-11e9-a715-74d02bd4fd82");
        System.out.println(user);
        // System.out.println(SecurityUtils.getSubject().getPrincipal());

    }

    @Test
    void contextLoads8() throws Exception {
        List<Users> allUsers = usersService.findAllUsers();
        System.out.println(allUsers);

    }

    @Test
    void contextLoads7() throws Exception {
        List<Orders> allOrders = ordersService.findAllOrders();
        for (Orders allOrder : allOrders) {
            System.out.println(allOrder);
        }
    }

    @Test
    void contextLoads6() throws Exception {
        UsersRole usersRole = new UsersRole();
        usersRole.setUserId("0bf31c8f-a51b-473c-8e1b-62be2c9fa3d8");
        System.out.println(usersRoleService.deleteUsersRole(usersRole));
    }

    @Test
    void contextLoads5() throws Exception {
        Role role = new Role();
        role.setId("160d9216-a152-11e9-b4b3-74d02bd4fd82");
        Role roleDetailsById = roleMapper.findRoleDetailsById(role);
        System.out.println(roleDetailsById);

    }

    @Test
    void contextLoads4() throws Exception {
        Users users = new Users();
        users.setId("ab07416d-a153-11e9-b4b3-74d02bd4fd82");
        System.out.println(usersService.findUserById(users));
        Users users1 = usersService.userDetails(users);
        System.out.println(users1);
    }

    @Test
    void contextLoads3() throws Exception {

        List<UsersRole> allUsersRoles = usersRoleService.findAllUsersRoles();
        for (UsersRole allUsersRole : allUsersRoles) {
            System.out.println(allUsersRole);
        }

    }

    @Test
    void contextLoads2() throws Exception {

        for (int i = 0; i < 20; i++) {
            Users users = new Users();
            users.setEmail("113" + i + "@163.com");
            users.setUsername("赵煜东3" + i);
            usersService.insertUser(users);
        }

    }


    @Test
    void contextLoads() throws Exception {
        // System.out.println(dataSource.getConnection());
        for (Users allUser : usersService.findAllUsers()) {
            allUser.setPassword("123456");
            allUser.setPassword(MD5Util.md5Hash(allUser));
            usersService.updateUser(allUser);
        }
        /*for (int i = 0; i < 20; i++) {
            Users users = new Users();
            users.setEmail("113" + i + "@163.com");
            users.setUsername("赵煜东3" + i);
            usersService.insertUser(users);
        }
        System.out.println("**********************************************");
        Users users = new Users();
        // users.setUsername("chenhao");
        // System.out.println(usersService.findUserByName(users));
        users.setEmail("113@163.com");
        users.setUsername("赵煜东3");
        // users = usersService.findUserByName(users);
        // System.out.println(users);
        users.setPassword("123456");
        // users.setId(UUID.randomUUID().toString());
        System.out.println(users);
        System.out.println("插入" + usersService.insertUser(users));
        System.out.println(users);
        System.out.println("插入后" + usersService.findUserByName(users));
        users.setPassword("654321");
        System.out.println("更新" + usersService.updateUser(users));
        System.out.println("更新后" + usersService.findUserByName(users));
        System.out.println("删除" + usersService.deleteUser(users));
        System.out.println("**********************************************");
        // System.out.println(dataSource.getConnection());
        for (Users allUser : usersService.findAllUsers()) {
            System.out.println(allUser);
        }*/


    }

}
