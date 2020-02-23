package com.csw.action;

import com.csw.entity.Product;
import com.csw.service.ProductService;
import com.csw.service.ProductServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductAction {
    private Integer id;
    private String productName;
    private Double price;
    private String picpath;
    private String discription;
    private Product product;

    public String FirstPageAction() {
        System.out
                .println("welcome to FirstPageAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpServletRequest request = ServletActionContext.getRequest();
        ProductService ps = new ProductServiceImpl();
        Integer countPage = ps.countPageAction();
        System.out.println("\\firstPage countPage//" + countPage);
        List<Product> list = ps.queryPersonByArray(1, 2, countPage);
        System.out.println("\\firstPage//" + list);

        HttpSession session = request.getSession();
        session.setAttribute("countPage", countPage);
        String judge = "judge";
        session.setAttribute("judge", judge);
        session.setAttribute("list", list);
        session.setAttribute("currPage", 1);
        return "true";

    }

    public String PreviousPageAction() {
        System.out
                .println("welcome to PreviousPageAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");
        String currPageInteger = request.getParameter("currPage");
        Integer currPage = Integer.parseInt(currPageInteger);

        ProductService ps = new ProductServiceImpl();

        List<Product> list = ps.queryPersonByArray(currPage, 2, countPage);
        System.out.println(" CurrentPageAction list//" + list);

        String judge = "judge";
        session.setAttribute("judge", judge);
        session.setAttribute("list", list);
        session.setAttribute("currPage", currPage);
        return "true";

    }

    public String CurrentPageAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to CurrentPageAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");
        String currPageInteger = request.getParameter("currPage");
        Integer currPage = Integer.parseInt(currPageInteger);
        System.out.println("{{CurrentPageAction}=" + currPageInteger);
        System.out.println("{{CurrentPageAction}=" + currPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArray(currPage, 2, countPage);
        System.out.println(" {{CurrentPageAction list}=" + list);

        String judge = "judge";
        session.setAttribute("judge", judge);
        session.setAttribute("list", list);
        session.setAttribute("currPage", currPage);
        return "true";

    }

    public String NextPageAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to NextPageAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");
        String currPageInteger = request.getParameter("currPage");
        Integer currPage = Integer.parseInt(currPageInteger);
        System.out.println("\\next currPage//" + currPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArray(currPage, 2, countPage);

        System.out.println(" CurrentPageAction list//" + list);

        String judge = "judge";
        session.setAttribute("judge", judge);
        session.setAttribute("list", list);
        session.setAttribute("currPage", currPage);
        return "true";

    }

    public String LastPageAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to LastPageAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");

        System.out.println("\\firstPage countPage//" + countPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArray(countPage, 2, countPage);// /
        System.out.println(" CurrentPageAction list//" + list);

        String judge = "judge";
        session.setAttribute("judge", judge);
        session.setAttribute("list", list);
        session.setAttribute("currPage", countPage);
        return "true";

    }

    public String MapSelectAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to MapSelectAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        // ��sesssion������ȡ��mapend
        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        Set<Product> set3 = mapEnd.keySet();
        for (Product x : set3) {
            System.out.println("\n����mapend=" + x + "\n" + mapEnd.get(x));
        }
        // ��ȡ�����Ʒ��id
        String idstr = request.getParameter("nameid");
        Integer id = Integer.parseInt(idstr);
        // ��ȡ����Ʒ�Ķ���
        ProductService ps = new ProductServiceImpl();
        Product pro = ps.getProductById(id);

        boolean flag = true;
        // ���������ж��Ƿ���ڣ����н��Ƚϣ�������Ϊfalse
        for (Product x : set3) {
            if (x.equals(pro)) {
                flag = false;
            }
        }

        if (flag) {// ���������
            mapEnd.put(pro, 1);
        } else {
            // �������
            mapEnd.put(pro, mapEnd.get(pro) + 1);
        }

        for (Product x : set3) {
            System.out.println("\n�ٴα���mapend=" + x + "\n" + mapEnd.get(x));
        }
        // ��session������ȡ��map
        Map<Product, Integer> map = (Map<Product, Integer>) session
                .getAttribute("map");
        Set<Product> set1 = map.keySet();
        for (Product p : set1) {
            System.out.println("\n����map=" + p + "\n" + map.get(p));
        }

        // ��map��ֵ
        map.clear();
        for (Product p : set3) {
            map.put(p, mapEnd.get(p));
            System.out.println("\n�ٴα���map=" + p);
        }
        // ����������

        session.setAttribute("mapEnd", mapEnd);

        session.setAttribute("map", map);

        return "true";
    }

    public String SubmitChangeAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to SubmitChangeAction$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        // ���������ȡmap
        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        Set<Product> set3 = mapEnd.keySet();

        for (Product x : set3) {
            System.out.println("\n{�ж�}����mapend=" + x + "\n" + mapEnd.get(x));
        }
        // ��ȡѡ�е���Ʒid
        String[] ids = request.getParameterValues("ids");
        System.out.println("/nSubmitChangeAction-ids=" + ids);
        String[] number = request.getParameterValues("1");
        System.out.println("/nSubmitChangeAction-number=" + number);
        // ���������ȡmapsub

        if (ids == null) {

            return "false";
        } else {
            Map<Product, Integer> mapSub = (Map<Product, Integer>) session
                    .getAttribute("mapSub");
            Set<Product> set2 = mapSub.keySet();
            for (Product p : set2) {
                System.out.println("\n����mapsub" + p + "\n" + mapSub.get(p));
            }

            ProductService ps = new ProductServiceImpl();
            Product product;
            // ���mapsub
            mapSub.clear();
            // �����洢��mapsub
            for (int i = 0; i < ids.length; i++) {
                product = ps.getProductById(Integer.parseInt(ids[i]));
                mapSub.put(product, Integer.parseInt(number[i]));
            }

            for (Product p : set2) {
                System.out.println("\n�ٴα�����ӡmapsub" + p + "\n" + mapSub.get(p));
            }
            // ��session�������ȡmap
            Map<Product, Integer> map = (Map<Product, Integer>) session
                    .getAttribute("map");
            Set<Product> set1 = map.keySet();
            for (Product p : set1) {
                System.out.println("\n������ӡmap" + p + "\n" + map.get(p));
            }
            // ��mapsub��map
            // map = mapSub;
            map.clear();
            for (Product p : set2) {
                map.put(p, mapSub.get(p));
                System.out.println("\n�ٴα���map=" + p);
            }

            for (Product p : set1) {
                System.out.println("\n�ٴα���map" + p + "\n" + map.get(p));
            }

            for (Product x : set3) {
                System.out.println("\n{�ж�}�ٴα���mapend=" + x + "\n"
                        + mapEnd.get(x));
            }

            session.setAttribute("mapSub", mapSub);
            session.setAttribute("map", map);
            return "true";
        }

    }

    public String Cancle() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to Cancle$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        // ȡ��mapend
        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        Set<Product> set3 = mapEnd.keySet();
        for (Product x : set3) {
            System.out.println("\n������ӡmapend=" + x + "\n" + mapEnd.get(x));
        }
        // ȡ��map
        Map<Product, Integer> map = (Map<Product, Integer>) session
                .getAttribute("map");
        Set<Product> set1 = map.keySet();
        for (Product p : set1) {
            System.out.println("\n����map=" + p + "\n" + map.get(p));
        }
        // ��map��ֵ
        // map = mapEnd;
        map.clear();
        for (Product p : set3) {
            map.put(p, mapEnd.get(p));
            System.out.println("\n�ٴα���map=" + p);
        }
        for (Product p : set1) {
            System.out.println("\n�ٴα���map=" + p + "\n" + map.get(p));
        }

        for (Product x : set3) {
            System.out.println("\n�ٴα���mapend=" + x + "\n" + mapEnd.get(x));
        }
        // ����������
        session.setAttribute("map", map);

        return "true";

    }

    public String CompleteSubmission() {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out
                .println("welcome to CompleteSubmission$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HttpSession session = request.getSession();
        // ȡ��mapend
        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        System.out.println("ȡ����mapEnd" + mapEnd);

        Set<Product> set3 = mapEnd.keySet();
        System.out.println("set3" + set3);
        for (Product x : set3) {
            System.out.println("\n����mapend=" + x + "\n" + mapEnd.get(x));
        }

        // ��ȡmapsub
        Map<Product, Integer> mapSub = (Map<Product, Integer>) session
                .getAttribute("mapSub");
        System.out.println("ȡ����mapsub" + mapSub);
        Set<Product> set2 = mapSub.keySet();
        for (Product p : set2) {

            System.out.println("\n����mapsub=" + p);

        }
        // ��mapend��ֵ
        // mapEnd = mapSub;

        mapEnd.clear();
        for (Product p : set2) {
            mapEnd.put(p, mapSub.get(p));
            System.out.println("\n�ٴα���map=" + p);
        }
        for (Product p : set3) {
            System.out.println("\nCompleteSubmission-mapEnd2=" + p + "\n"
                    + mapEnd.get(p));
        }
        // ����������
        session.setAttribute("mapEnd", mapEnd);
        System.out.println("������mapend" + mapEnd);
        return "true";

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
