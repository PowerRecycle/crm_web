package com.crazycode.service.impl;

import com.crazycode.mapper.ProductMapper;
import com.crazycode.pojo.Product;
import com.crazycode.service.ProductService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductServiceImpl
 *
 * @author Administrator
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IndexWriter indexWriter;
    @Autowired
    private Directory directory;
    @Autowired
    private Analyzer analyzer;

    /**
     * 查询全部Product
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAllProducts() throws Exception {
        return productMapper.selectAll();
    }

    /**
     * 单个查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Product findProductById(String id) throws Exception {
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * 增
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int insertProduct(Product product) throws Exception {
        return productMapper.insert(product);
    }

    /**
     * 改
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int updateProduct(Product product) throws Exception {
        return productMapper.updateByPrimaryKey(product);
    }

    /**
     * 删
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteProduct(String id) throws Exception {
        return productMapper.deleteByPrimaryKey(id);
    }

    /**
     * 开启
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int openProduct(Product product) throws Exception {
        product.setProductStatus(1L);
        return productMapper.updateByPrimaryKey(product);
    }

    /**
     * 关闭
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int closeProduct(Product product) throws Exception {
        product.setProductStatus(0L);
        return productMapper.updateByPrimaryKey(product);
    }

    /**
     * 创建Products索引库
     *
     * @throws Exception
     */
    @Override
    public void createProductIndex() throws Exception {
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

    /**
     * 去索引库中查询短消息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> searchProducts(String queryString) throws Exception {
        //以读的方式打开索引库
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建索引库查询器对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        QueryParser queryParser = new QueryParser("productName", analyzer);
        Query query = queryParser.parse(queryString);
        TopDocs topDocs = indexSearcher.search(query, 20);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        ArrayList<Product> products = new ArrayList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            //获取查询到的docId
            int docId = scoreDoc.doc;
            Document doc = indexSearcher.doc(docId);
            Product product = new Product(
                    doc.get("id"),
                    doc.get("productNum"),
                    doc.get("productName"),
                    doc.get("cityName"),
                    doc.get("departureTime"),
                    Double.valueOf(doc.get("productPrice")),
                    doc.get("productDesc"),
                    Long.valueOf(doc.get("productStatus")));
            products.add(product);
        }
        return products;
    }
}
