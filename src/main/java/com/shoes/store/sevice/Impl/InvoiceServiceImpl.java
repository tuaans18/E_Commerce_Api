package com.shoes.store.sevice.Impl;

import com.shoes.store.repository.InvoiceRepository;
import com.shoes.store.repository.ProductOfInvoiceRepository;
import com.shoes.store.repository.ProductRepository;
import com.shoes.store.repository.UserRepository;
import com.shoes.store.repository.entity.Invoice;
import com.shoes.store.repository.entity.ProducOfInvoice;
import com.shoes.store.repository.entity.Product;
import com.shoes.store.repository.entity.Users;
import com.shoes.store.request.AddProductToCartRequest;
import com.shoes.store.request.DeleteProductInCartRequest;
import com.shoes.store.request.InvoiceRequest;
import com.shoes.store.request.UpdateCartRequest;
import com.shoes.store.respone.CartResponse;
import com.shoes.store.respone.ProductOfInvoiceRespone;
import com.shoes.store.sevice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductOfInvoiceRepository productOfInvoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public CartResponse getCart(String email) {
        Invoice invoice = invoiceRepository.findByStatusAndUser_Email(0,email);
        CartResponse cartResponse = new CartResponse();
        if(invoice == null){
            invoice = new Invoice();
            invoice.setStatus(0);
            Users users = userRepository.findByEmail(email);
            invoice.setUser(users);
            invoice = invoiceRepository.save(invoice);
        }else{
            List<ProducOfInvoice> producOfInvoices =  invoice.getProducOfInvoices();
            List<ProductOfInvoiceRespone> products = new ArrayList<>();
            Float total = 0f;
            for(ProducOfInvoice producOfInvoice : producOfInvoices){
                Product product = producOfInvoice.getProduct();
                ProductOfInvoiceRespone productOfInvoiceRespone = new ProductOfInvoiceRespone();
                total = total + producOfInvoice.getPrice()*producOfInvoice.getQuantity();
                productOfInvoiceRespone.setId(producOfInvoice.getId());
                productOfInvoiceRespone.setDescription(product.getDescription());
                productOfInvoiceRespone.setImg(product.getImg());
                productOfInvoiceRespone.setPrice(producOfInvoice.getPrice());
                productOfInvoiceRespone.setQuantity(producOfInvoice.getQuantity());
                productOfInvoiceRespone.setName(product.getName());
                products.add(productOfInvoiceRespone);

            }
            cartResponse.setProducts(products);
            cartResponse.setTotalPrice(total);
            invoice.setTotal(total);
            invoiceRepository.save(invoice);
        }
        return cartResponse;
    }

    @Override
    public void addProductToCart(AddProductToCartRequest addProductToCartRequest) {
        ProducOfInvoice producOfInvoice = new ProducOfInvoice();
        Optional<Product> product = productRepository.findById(addProductToCartRequest.getProductId());
        producOfInvoice.setProduct(product.get());
        Invoice invoice = invoiceRepository.findByStatusAndUser_Email(0,addProductToCartRequest.getEmail());
        producOfInvoice.setInvoice(invoice);
        producOfInvoice.setQuantity(addProductToCartRequest.getQuantity());
        producOfInvoice.setPrice(addProductToCartRequest.getPrice());
        productOfInvoiceRepository.save(producOfInvoice);
    }
    @Transactional
    @Override
    public void deleteProductInCart(DeleteProductInCartRequest deleteProductInCartRequest) {
        Invoice invoice = invoiceRepository.findByStatusAndUser_Email(0,deleteProductInCartRequest.getEmail());
        Long productId = deleteProductInCartRequest.getId();
        productOfInvoiceRepository.deleteByInvoice_IdAndProduct_Id(invoice.getId(),productId);
    }

    @Transactional
    @Override
    public void updateProductInCart(UpdateCartRequest updateCartRequest) {
        Invoice invoice = invoiceRepository.findByStatusAndUser_Email(0,updateCartRequest.getEmail());
        Long productId = updateCartRequest.getId();
        ProducOfInvoice producOfInvoice = productOfInvoiceRepository.findByInvoice_IdAndProduct_Id(invoice.getId(),productId);
        producOfInvoice.setQuantity(updateCartRequest.getQuantity());
        productOfInvoiceRepository.save(producOfInvoice);
    }


    @Override
    public void payInvoice(InvoiceRequest invoiceRequest) {
        Invoice invoice = invoiceRepository.findByStatusAndUser_Email(0,invoiceRequest.getEmail());
        invoice.setDeliveryAddress(invoiceRequest.getDeliveryAddress());
        invoice.setStatus(1);
        invoice.setShippingFee(20f);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        String strNow = sdf.format(now);
        try {
            invoice.setDate(sdf.parse(strNow));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        invoiceRepository.save(invoice);
    }


}
