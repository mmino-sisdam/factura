SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `facturacion` DEFAULT CHARACTER SET latin1 ;
USE `facturacion` ;

-- -----------------------------------------------------
-- Table `facturacion`.`tipo_iva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`tipo_iva` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`tipo_iva` (
  `tipo_iva_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_iva_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`tipo_retencion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`tipo_retencion` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`tipo_retencion` (
  `tipo_retencion_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_retencion_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`clientes` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`clientes` (
  `cliente_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cuit` VARCHAR(11) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  `localizacion` VARCHAR(255) NULL DEFAULT NULL,
  `tipo_iva_id` INT(11) NOT NULL,
  `tipo_retencion_id` INT(11) NOT NULL,
  PRIMARY KEY (`cliente_id`),
  INDEX `fk_clientes_tipo_iva1_idx` (`tipo_iva_id` ASC),
  INDEX `fk_clientes_tipo_retencion1_idx` (`tipo_retencion_id` ASC),
  CONSTRAINT `fk_clientes_tipo_iva1`
    FOREIGN KEY (`tipo_iva_id`)
    REFERENCES `facturacion`.`tipo_iva` (`tipo_iva_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_tipo_retencion1`
    FOREIGN KEY (`tipo_retencion_id`)
    REFERENCES `facturacion`.`tipo_retencion` (`tipo_retencion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`linea_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`linea_producto` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`linea_producto` (
  `linea_producto_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`linea_producto_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`roles` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`roles` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NULL DEFAULT NULL,
  `descrip` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`personas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`personas` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`personas` (
  `persona_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `mail` VARCHAR(50) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(50) NULL DEFAULT NULL,
  `access_enabled` TINYINT(1) NULL DEFAULT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`persona_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_personas_roles_idx` (`role_id` ASC),
  CONSTRAINT `fk_personas_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `facturacion`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`status` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`status` (
  `status_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`tipo_comision`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`tipo_comision` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`tipo_comision` (
  `tipo_comision_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_comision_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`tipo_comprobante_entregable`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`tipo_comprobante_entregable` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`tipo_comprobante_entregable` (
  `tipo_comprobante_entregable_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_comprobante_entregable_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`tipo_factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`tipo_factura` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`tipo_factura` (
  `tipo_factura_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_factura_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`facturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`facturas` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`facturas` (
  `tipo_factura_id` INT(11) NOT NULL,
  `factura_id` INT(11) NOT NULL,
  `cliente_id` INT(11) NOT NULL,
  `contacto` VARCHAR(255) NULL DEFAULT NULL,
  `persona_id` INT(11) NOT NULL,
  `fecha_emision` DATE NOT NULL,
  `fecha_vencimiento` DATE NULL DEFAULT NULL,
  `fecha_probable_cobro` DATE NULL DEFAULT NULL,
  `fecha_cobro` DATE NULL DEFAULT NULL,
  `importe_subtotal` DECIMAL(12,2) NOT NULL,
  `importe_iva` DECIMAL(12,2) NOT NULL,
  `importe_total` DECIMAL(12,2) NOT NULL,
  `persona_responsable_id` INT(11) NOT NULL,
  `importe_comision` DECIMAL(12,2) NULL DEFAULT NULL,
  `importe_cobrado` DECIMAL(12,2) NULL DEFAULT NULL,
  `fecha_comprobante_entregable` DATE NULL DEFAULT NULL,
  `importe_costo` DECIMAL(12,2) NULL DEFAULT NULL,
  `importe_rentabilidad` DECIMAL(12,2) NULL DEFAULT NULL,
  `forma_pago` VARCHAR(255) NULL DEFAULT NULL,
  `remito` VARCHAR(50) NULL DEFAULT NULL,
  `orden_compra` VARCHAR(50) NULL DEFAULT NULL,
  `status_id` INT(11) NOT NULL,
  `tipo_comision_id` INT(11) NOT NULL,
  `tipo_comprobante_entregable_id` INT(11) NULL DEFAULT NULL,
  `linea_producto_id` INT(11) NOT NULL,
  `tipo_iva_id` INT(11) NOT NULL,
  `tipo_retencion_id` INT(11) NOT NULL,
  PRIMARY KEY (`tipo_factura_id`, `factura_id`),
  INDEX `fk_facturas_clientes1_idx` (`cliente_id` ASC),
  INDEX `fk_facturas_personas1_idx` (`persona_id` ASC),
  INDEX `fk_facturas_personas2_idx` (`persona_responsable_id` ASC),
  INDEX `fk_facturas_tipo_factura1_idx` (`tipo_factura_id` ASC),
  INDEX `fk_facturas_status1_idx` (`status_id` ASC),
  INDEX `fk_facturas_tipo_comprobante_entregable1_idx` (`tipo_comprobante_entregable_id` ASC),
  INDEX `fk_facturas_linea_producto1_idx` (`linea_producto_id` ASC),
  INDEX `fk_facturas_tipo_iva1_idx` (`tipo_iva_id` ASC),
  INDEX `fk_facturas_tipo_retencion1_idx` (`tipo_retencion_id` ASC),
  INDEX `fk_facturas_tipo_comision1_idx` (`tipo_comision_id` ASC),
  CONSTRAINT `fk_facturas_clientes1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `facturacion`.`clientes` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_linea_producto1`
    FOREIGN KEY (`linea_producto_id`)
    REFERENCES `facturacion`.`linea_producto` (`linea_producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_personas1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `facturacion`.`personas` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_personas2`
    FOREIGN KEY (`persona_responsable_id`)
    REFERENCES `facturacion`.`personas` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `facturacion`.`status` (`status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_tipo_comision1`
    FOREIGN KEY (`tipo_comision_id`)
    REFERENCES `facturacion`.`tipo_comision` (`tipo_comision_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_tipo_comprobante_entregable1`
    FOREIGN KEY (`tipo_comprobante_entregable_id`)
    REFERENCES `facturacion`.`tipo_comprobante_entregable` (`tipo_comprobante_entregable_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_tipo_factura1`
    FOREIGN KEY (`tipo_factura_id`)
    REFERENCES `facturacion`.`tipo_factura` (`tipo_factura_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_tipo_iva1`
    FOREIGN KEY (`tipo_iva_id`)
    REFERENCES `facturacion`.`tipo_iva` (`tipo_iva_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_tipo_retencion1`
    FOREIGN KEY (`tipo_retencion_id`)
    REFERENCES `facturacion`.`tipo_retencion` (`tipo_retencion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `facturacion`.`factura_detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturacion`.`factura_detalle` ;

CREATE TABLE IF NOT EXISTS `facturacion`.`factura_detalle` (
  `tipo_factura_id` INT(11) NOT NULL,
  `factura_id` INT(11) NOT NULL,
  `detalle` VARCHAR(255) NOT NULL,
  `cantidad` INT(11) NULL DEFAULT NULL,
  `importe_unitario` DECIMAL(12,2) NULL DEFAULT NULL,
  `importe_total` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`tipo_factura_id`, `factura_id`),
  CONSTRAINT `fk_factura_detalle_facturas1`
    FOREIGN KEY (`tipo_factura_id` , `factura_id`)
    REFERENCES `facturacion`.`facturas` (`tipo_factura_id` , `factura_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
