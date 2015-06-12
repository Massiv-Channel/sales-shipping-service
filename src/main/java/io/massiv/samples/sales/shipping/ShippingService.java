package io.massiv.samples.sales.shipping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.newrelic.api.agent.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/shipping")
public class ShippingService {
    private Map<String, ShippingRequest> orders = new ConcurrentHashMap<String, ShippingRequest>();

    @Autowired
    protected AuditService auditService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShippingRequest getOrder(@PathVariable String id) {
        return orders.get(id);
    }

    @Trace
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void create(@RequestBody ShippingRequest request) {
        System.out.println("Shipping request received: " + request.getItem() + " Quantity: " + request.getQuantity());

        orders.put(request.getItem(), request);
        auditService.orderReceived(request);

    }
}
