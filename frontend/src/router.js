
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderAndPaymentOrderManager from "./components/listers/OrderAndPaymentOrderCards"
import OrderAndPaymentOrderDetail from "./components/listers/OrderAndPaymentOrderDetail"
import OrderAndPaymentPaymentManager from "./components/listers/OrderAndPaymentPaymentCards"
import OrderAndPaymentPaymentDetail from "./components/listers/OrderAndPaymentPaymentDetail"
import OrderAndPaymentOrderNotificationManager from "./components/listers/OrderAndPaymentOrderNotificationCards"
import OrderAndPaymentOrderNotificationDetail from "./components/listers/OrderAndPaymentOrderNotificationDetail"

import OrderSummaryView from "./components/OrderSummaryView"
import OrderSummaryViewDetail from "./components/OrderSummaryViewDetail"
import OrderDetailsView from "./components/OrderDetailsView"
import OrderDetailsViewDetail from "./components/OrderDetailsViewDetail"
import PaymentSummaryView from "./components/PaymentSummaryView"
import PaymentSummaryViewDetail from "./components/PaymentSummaryViewDetail"
import PaymentDetailsView from "./components/PaymentDetailsView"
import PaymentDetailsViewDetail from "./components/PaymentDetailsViewDetail"
import OrderNotificationSummaryView from "./components/OrderNotificationSummaryView"
import OrderNotificationSummaryViewDetail from "./components/OrderNotificationSummaryViewDetail"
import RestaurantManagementRestaurantManager from "./components/listers/RestaurantManagementRestaurantCards"
import RestaurantManagementRestaurantDetail from "./components/listers/RestaurantManagementRestaurantDetail"
import RestaurantManagementMenuManager from "./components/listers/RestaurantManagementMenuCards"
import RestaurantManagementMenuDetail from "./components/listers/RestaurantManagementMenuDetail"

import NewOrdersView from "./components/NewOrdersView"
import NewOrdersViewDetail from "./components/NewOrdersViewDetail"
import MenuListView from "./components/MenuListView"
import MenuListViewDetail from "./components/MenuListViewDetail"
import DeliveryManagementDeliveryManager from "./components/listers/DeliveryManagementDeliveryCards"
import DeliveryManagementDeliveryDetail from "./components/listers/DeliveryManagementDeliveryDetail"

import AssignedDeliveryOrdersView from "./components/AssignedDeliveryOrdersView"
import AssignedDeliveryOrdersViewDetail from "./components/AssignedDeliveryOrdersViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderAndPayments/orders',
                name: 'OrderAndPaymentOrderManager',
                component: OrderAndPaymentOrderManager
            },
            {
                path: '/orderAndPayments/orders/:id',
                name: 'OrderAndPaymentOrderDetail',
                component: OrderAndPaymentOrderDetail
            },
            {
                path: '/orderAndPayments/payments',
                name: 'OrderAndPaymentPaymentManager',
                component: OrderAndPaymentPaymentManager
            },
            {
                path: '/orderAndPayments/payments/:id',
                name: 'OrderAndPaymentPaymentDetail',
                component: OrderAndPaymentPaymentDetail
            },
            {
                path: '/orderAndPayments/orderNotifications',
                name: 'OrderAndPaymentOrderNotificationManager',
                component: OrderAndPaymentOrderNotificationManager
            },
            {
                path: '/orderAndPayments/orderNotifications/:id',
                name: 'OrderAndPaymentOrderNotificationDetail',
                component: OrderAndPaymentOrderNotificationDetail
            },

            {
                path: '/orderAndPayments/orderSummaries',
                name: 'OrderSummaryView',
                component: OrderSummaryView
            },
            {
                path: '/orderAndPayments/orderSummaries/:id',
                name: 'OrderSummaryViewDetail',
                component: OrderSummaryViewDetail
            },
            {
                path: '/orderAndPayments/orderDetails',
                name: 'OrderDetailsView',
                component: OrderDetailsView
            },
            {
                path: '/orderAndPayments/orderDetails/:id',
                name: 'OrderDetailsViewDetail',
                component: OrderDetailsViewDetail
            },
            {
                path: '/orderAndPayments/paymentSummaries',
                name: 'PaymentSummaryView',
                component: PaymentSummaryView
            },
            {
                path: '/orderAndPayments/paymentSummaries/:id',
                name: 'PaymentSummaryViewDetail',
                component: PaymentSummaryViewDetail
            },
            {
                path: '/orderAndPayments/paymentDetails',
                name: 'PaymentDetailsView',
                component: PaymentDetailsView
            },
            {
                path: '/orderAndPayments/paymentDetails/:id',
                name: 'PaymentDetailsViewDetail',
                component: PaymentDetailsViewDetail
            },
            {
                path: '/orderAndPayments/orderNotificationSummaries',
                name: 'OrderNotificationSummaryView',
                component: OrderNotificationSummaryView
            },
            {
                path: '/orderAndPayments/orderNotificationSummaries/:id',
                name: 'OrderNotificationSummaryViewDetail',
                component: OrderNotificationSummaryViewDetail
            },
            {
                path: '/restaurantManagements/restaurants',
                name: 'RestaurantManagementRestaurantManager',
                component: RestaurantManagementRestaurantManager
            },
            {
                path: '/restaurantManagements/restaurants/:id',
                name: 'RestaurantManagementRestaurantDetail',
                component: RestaurantManagementRestaurantDetail
            },
            {
                path: '/restaurantManagements/menus',
                name: 'RestaurantManagementMenuManager',
                component: RestaurantManagementMenuManager
            },
            {
                path: '/restaurantManagements/menus/:id',
                name: 'RestaurantManagementMenuDetail',
                component: RestaurantManagementMenuDetail
            },

            {
                path: '/restaurantManagements/newOrders',
                name: 'NewOrdersView',
                component: NewOrdersView
            },
            {
                path: '/restaurantManagements/newOrders/:id',
                name: 'NewOrdersViewDetail',
                component: NewOrdersViewDetail
            },
            {
                path: '/restaurantManagements/menuLists',
                name: 'MenuListView',
                component: MenuListView
            },
            {
                path: '/restaurantManagements/menuLists/:id',
                name: 'MenuListViewDetail',
                component: MenuListViewDetail
            },
            {
                path: '/deliveryManagements/deliveries',
                name: 'DeliveryManagementDeliveryManager',
                component: DeliveryManagementDeliveryManager
            },
            {
                path: '/deliveryManagements/deliveries/:id',
                name: 'DeliveryManagementDeliveryDetail',
                component: DeliveryManagementDeliveryDetail
            },

            {
                path: '/deliveryManagements/assignedDeliveryOrders',
                name: 'AssignedDeliveryOrdersView',
                component: AssignedDeliveryOrdersView
            },
            {
                path: '/deliveryManagements/assignedDeliveryOrders/:id',
                name: 'AssignedDeliveryOrdersViewDetail',
                component: AssignedDeliveryOrdersViewDetail
            },


    ]
})
