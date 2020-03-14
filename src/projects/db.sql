CREATE TABLE `event` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `venue` varchar(30) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `variousprograms` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




CREATE TABLE `login` (`username` varchar(30) DEFAULT NULL, `password` varchar(30) DEFAULT NULL)ENGINE=MyISAM DEFAULT CHARSET=latin1;

