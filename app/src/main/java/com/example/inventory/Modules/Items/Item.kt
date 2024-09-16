package com.example.inventory.Modules.Items

data class Item(
    val item_id: String,
    val name: String,
)



//1000.35f20e1aad4b936d0ef5f292ae7b7066.bc76ec41b1667f946a065825b9c39eca
//1000.82ebaef19b4f227f7018767e936a070f.33673b9ae2affa3640226b0bdc9d2646

//
//Response : {"code":0,"message":"success","items":[{"item_id":"1986850000000067365","name":"A1","item_name":"A1","unit":"pcs","status":"active","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":10,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":8,"item_type":"inventory","product_type":"goods","stock_on_hand":9,"has_attachment":false,"is_returnable":true,"available_stock":9,"actual_available_stock":10,"sku":"","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"reorder_level":2,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-14T09:17:16+0530","last_modified_time":"2024-08-26T11:28:28+0530","show_in_storefront":false,"length":"","width":"","height":"","weight":"","weight_unit":"kg","dimension_unit":"cm"},{"item_id":"1986850000000046565","name":"ABC-Item10","item_name":"ABC-Item10","unit":"box","status":"inactive","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":100,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":100,"item_type":"inventory","product_type":"goods","stock_on_hand":10,"has_attachment":false,"is_returnable":true,"available_stock":10,"actual_available_stock":17,"sku":"","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"reorder_level":3,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-12T12:54:01+0530","last_modified_time":"2024-08-12T17:19:06+0530","show_in_storefront":false,"length":10,"width":10,"height":10,"weight":10,"weight_unit":"kg","dimension_unit":"cm"},{"item_id":"1986850000000032038","name":"Acer Aspire 7 512 gb","item_name":"Acer Aspire 7 512 gb","unit":"pcs","status":"active","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":65000,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":52000,"item_type":"sales_and_purchases","product_type":"goods","has_attachment":false,"is_returnable":false,"sku":"","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-07T13:04:11+0530","last_modified_time":"2024-08-07T13:04:11+0530","show_in_storefront":true,"length":"","width":"","height":"","weight":"","weight_unit":"kg","dimension_unit":"cm"},{"item_id":"1986850000000053724","name":"AC_service","item_name":"AC_service","unit":"kg","status":"active","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":1200,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":1000,"item_type":"sales_and_purchases","product_type":"service","has_attachment":false,"is_returnable":false,"sku":"AC-SERV-01","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-12T16:29:46+0530","last_modified_time":"2024-08-12T16:29:46+0530","show_in_storefront":false,"length":100,"width":100,"height":100,"weight":100,
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067365, name=A1)
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000046565, name=ABC-Item10)
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032038, name=Acer Aspire 7 512 gb)
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053724, name=AC_service)
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000033019, name=Apple MacBook M3 Pro/Max (16-inch))
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036003, name=Asus Nitro n5 16 / 512)
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000033010, name=ASUS ROG STRIX SCAR 17 X3D)
//    2024-09-16 10:55:43.700  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067159, name=Aus Rog strix scar)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000028037, name=Biscuit1)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053951, name=CheckItem1)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032029, name=Dell G15 5515)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000046255, name=Dell G15 5515 16/512)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000033001, name=Dell XPS 13 9345)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057514, name=intel i5 11th gen)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000037129, name=Item1)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000044601, name=item1)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000046439, name=item10)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000037154, name=Item2)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036030, name=Laptops-black/14inch/16gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036032, name=Laptops-black/14inch/8gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036034, name=Laptops-black/15.2inch/16gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036036, name=Laptops-black/15.2inch/8gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036038, name=Laptops-black/15.4inch/16gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036040, name=Laptops-black/15.4inch/8gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036042, name=Laptops-blue/14inch/16gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036044, name=Laptops-blue/14inch/8gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036046, name=Laptops-blue/15.2inch/16gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036048, name=Laptops-blue/15.2inch/8gb)
//    2024-09-16 10:55:43.701  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036050, name=Laptops-blue/15.4inch/16gb)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036052, name=Laptops-blue/15.4inch/8gb)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057483, name=LPDDR4 RAM)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032020, name=MacBook air m1 512 gb)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032011, name=MacBook pro m1 256 gb)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057091, name=Medical Gloves)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000039726, name=nonReturnableItem1)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000062740, name=Nvidia RTX 3050)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067684, name=SampleGood1)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000080421, name=SampleItem To Check Webhook)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057032, name=SampleItem1)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032047, name=Samsung Galaxy Book2 512 gb)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067822, name=Sony TV 1)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067460, name=Z1)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053133, name=Zoho-Item-2)
//    2024-09-16 10:55:43.702  3380-3380  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053098, name=Zoho-Item1)
//    2024-09-16 10:57:39.506  3759-3863  System.out              com.example.inventory                I  Access Token : 1000.35f20e1aad4b936d0ef5f292ae7b7066.bc76ec41b1667f946a065825b9c39eca
//    2024-09-16 10:57:40.462  3759-3759  System.out              com.example.inventory                I  Response : {"code":0,"message":"success","items":[{"item_id":"1986850000000067365","name":"A1","item_name":"A1","unit":"pcs","status":"active","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":10,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":8,"item_type":"inventory","product_type":"goods","stock_on_hand":9,"has_attachment":false,"is_returnable":true,"available_stock":9,"actual_available_stock":10,"sku":"","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"reorder_level":2,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-14T09:17:16+0530","last_modified_time":"2024-08-26T11:28:28+0530","show_in_storefront":false,"length":"","width":"","height":"","weight":"","weight_unit":"kg","dimension_unit":"cm"},{"item_id":"1986850000000046565","name":"ABC-Item10","item_name":"ABC-Item10","unit":"box","status":"inactive","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":100,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":100,"item_type":"inventory","product_type":"goods","stock_on_hand":10,"has_attachment":false,"is_returnable":true,"available_stock":10,"actual_available_stock":17,"sku":"","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"reorder_level":3,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-12T12:54:01+0530","last_modified_time":"2024-08-12T17:19:06+0530","show_in_storefront":false,"length":10,"width":10,"height":10,"weight":10,"weight_unit":"kg","dimension_unit":"cm"},{"item_id":"1986850000000032038","name":"Acer Aspire 7 512 gb","item_name":"Acer Aspire 7 512 gb","unit":"pcs","status":"active","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":65000,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":52000,"item_type":"sales_and_purchases","product_type":"goods","has_attachment":false,"is_returnable":false,"sku":"","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-07T13:04:11+0530","last_modified_time":"2024-08-07T13:04:11+0530","show_in_storefront":true,"length":"","width":"","height":"","weight":"","weight_unit":"kg","dimension_unit":"cm"},{"item_id":"1986850000000053724","name":"AC_service","item_name":"AC_service","unit":"kg","status":"active","source":"user","is_combo_product":false,"is_linked_with_zohocrm":false,"zcrm_product_id":"","description":"","brand":"","manufacturer":"","rate":1200,"tax_id":"","tax_name":"","tax_percentage":0,"purchase_account_id":"1986850000000000567","purchase_account_name":"Cost of Goods Sold","account_id":"1986850000000000486","account_name":"Sales","purchase_description":"","purchase_rate":1000,"item_type":"sales_and_purchases","product_type":"service","has_attachment":false,"is_returnable":false,"sku":"AC-SERV-01","upc":"","ean":"","isbn":"","part_number":"","track_serial_number":false,"track_batch_number":false,"image_name":"","image_type":"","image_document_id":"","created_time":"2024-08-12T16:29:46+0530","last_modified_time":"2024-08-12T16:29:46+0530","show_in_storefront":false,"length":100,"width":100,"height":100,"weight":100,
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067365, name=A1)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000046565, name=ABC-Item10)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032038, name=Acer Aspire 7 512 gb)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053724, name=AC_service)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000033019, name=Apple MacBook M3 Pro/Max (16-inch))
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036003, name=Asus Nitro n5 16 / 512)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000033010, name=ASUS ROG STRIX SCAR 17 X3D)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067159, name=Aus Rog strix scar)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053951, name=CheckItem1)
//    2024-09-16 10:57:40.555  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000028037, name=Biscuit1)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000046255, name=Dell G15 5515 16/512)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000033001, name=Dell XPS 13 9345)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032029, name=Dell G15 5515)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057514, name=intel i5 11th gen)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000037129, name=Item1)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000044601, name=item1)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000046439, name=item10)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000037154, name=Item2)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036030, name=Laptops-black/14inch/16gb)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036032, name=Laptops-black/14inch/8gb)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036034, name=Laptops-black/15.2inch/16gb)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036036, name=Laptops-black/15.2inch/8gb)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036038, name=Laptops-black/15.4inch/16gb)
//    2024-09-16 10:57:40.556  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036040, name=Laptops-black/15.4inch/8gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036042, name=Laptops-blue/14inch/16gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036044, name=Laptops-blue/14inch/8gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036046, name=Laptops-blue/15.2inch/16gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036048, name=Laptops-blue/15.2inch/8gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036050, name=Laptops-blue/15.4inch/16gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000036052, name=Laptops-blue/15.4inch/8gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057483, name=LPDDR4 RAM)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032020, name=MacBook air m1 512 gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032011, name=MacBook pro m1 256 gb)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057091, name=Medical Gloves)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000039726, name=nonReturnableItem1)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000062740, name=Nvidia RTX 3050)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067684, name=SampleGood1)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000080421, name=SampleItem To Check Webhook)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000057032, name=SampleItem1)
//    2024-09-16 10:57:40.557  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000032047, name=Samsung Galaxy Book2 512 gb)
//    2024-09-16 10:57:40.558  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067822, name=Sony TV 1)
//    2024-09-16 10:57:40.558  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000067460, name=Z1)
//    2024-09-16 10:57:40.558  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053133, name=Zoho-Item-2)
//    2024-09-16 10:57:40.558  3759-3759  System.out              com.example.inventory                I  item : Item(item_id=1986850000000053098, name=Zoho-Item1)
//    2024-09-16 11:00:01.539  4110-4223  System.out              com.example.inventory                I  Access Token : 1000.82ebaef19b4f227f7018767e936a070f.33673b9ae2affa3640226b0bdc9d2646
//        ---------------------------- PROCESS ENDED (4110) for package com.example.inventory ----------------------------