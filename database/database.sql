INSERT INTO `store`.`roles` (`role_id`, `rolename`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `store`.`roles` (`role_id`, `rolename`) VALUES ('2', 'ROLE_USER');


INSERT INTO `store`.`category` (`img`, `name`) VALUES ('xx.jpg', 'Giầy thể thao');
INSERT INTO `store`.`category` (`img`, `name`) VALUES ('yyy.jpg', 'Giầy thời trang');

INSERT INTO `store`.`product` (`description`, `img`, `name`, `price`, `quantity`, `category`) VALUES ('Giay dung cho chay bo', 'aaa.jpg', 'Giầy Converse 1970s Trắng', '200', '20', '1');
INSERT INTO `store`.`product` (`description`, `img`, `name`, `price`, `quantity`, `category`) VALUES ('Giầy cho chạy bộ', 'bb.hpg', 'Giày thể thao RENBEN', '300', '50', '1');
INSERT INTO `store`.`product` (`description`, `img`, `name`, `price`, `quantity`, `category`) VALUES ('Giầy thời trang', 'cc.jpg', 'Giầy thời trang', '400', '30', '2');
