CREATE TABLE tb_category (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             name VARCHAR(100) NOT NULL,
                             parent_id BIGINT DEFAULT NULL,
                             level INT NOT NULL,
                             icon VARCHAR(255) DEFAULT NULL,
                             sort INT DEFAULT 0,
                             is_show BOOLEAN DEFAULT TRUE,
                             attribute_ids TEXT,
                             create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- 单独创建索引
CREATE INDEX IF NOT EXISTS idx_parent_id ON tb_category(parent_id);
CREATE INDEX IF NOT EXISTS idx_level ON tb_category(level);

-- 添加注释（H2 特有的 COMMENT 语法）
COMMENT ON TABLE tb_category IS '商品分类表';
COMMENT ON COLUMN tb_category.id IS '分类ID';
COMMENT ON COLUMN tb_category.name IS '分类名称';
COMMENT ON COLUMN tb_category.parent_id IS '父分类ID';
COMMENT ON COLUMN tb_category.level IS '分类级别';
COMMENT ON COLUMN tb_category.icon IS '分类图标';
COMMENT ON COLUMN tb_category.sort IS '排序值';
COMMENT ON COLUMN tb_category.is_show IS '是否显示';
COMMENT ON COLUMN tb_category.attribute_ids IS '关联属性ID列表(JSON数组)';


CREATE TABLE tb_attribute (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              category_id BIGINT NOT NULL,
                              name VARCHAR(100) NOT NULL,
                              value_type VARCHAR(20) NOT NULL,
                              options TEXT,
                              is_required BOOLEAN DEFAULT FALSE,
                              is_searchable BOOLEAN DEFAULT FALSE,
                              sort INT DEFAULT 0,
                              create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- 外键约束（可选，根据业务需求决定是否添加）
                              CONSTRAINT fk_attribute_category FOREIGN KEY (category_id) REFERENCES tb_category(id)
);

-- 单独创建索引
CREATE INDEX IF NOT EXISTS idx_category_id ON tb_attribute(category_id);
CREATE INDEX IF NOT EXISTS idx_sort ON tb_attribute(sort);


-- 添加注释
COMMENT ON TABLE tb_attribute IS '商品属性表';
COMMENT ON COLUMN tb_attribute.id IS '属性ID';
COMMENT ON COLUMN tb_attribute.category_id IS '所属分类ID';
COMMENT ON COLUMN tb_attribute.name IS '属性名称';
COMMENT ON COLUMN tb_attribute.value_type IS '属性类型（text-文本/number-数字/select-单选/multi-多选）';
COMMENT ON COLUMN tb_attribute.options IS '可选值（JSON格式）';
COMMENT ON COLUMN tb_attribute.is_required IS '是否必填';
COMMENT ON COLUMN tb_attribute.is_searchable IS '是否可搜索';
COMMENT ON COLUMN tb_attribute.sort IS '排序值';

CREATE TABLE tb_product (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(200) NOT NULL,
                            sub_title VARCHAR(255) DEFAULT NULL,
                            description TEXT,
                            category_id BIGINT NOT NULL,
                            original_price DECIMAL(10, 2) NOT NULL,
                            current_price DECIMAL(10, 2) NOT NULL,
                            stock INT DEFAULT 0,
                            sales INT DEFAULT 0,
                            sort INT DEFAULT 0,
                            status TINYINT DEFAULT 1 COMMENT '1-上架，2-下架，3-删除',
                            images TEXT,
                            gallery TEXT,
                            create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            product_type TINYINT DEFAULT 1 COMMENT '1-实物，2-虚拟，3-服务',
                            extra_info TEXT,
                            -- 外键约束
                            CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES tb_category(id)
);

-- 单独创建索引
CREATE INDEX IF NOT EXISTS idx_category_id ON tb_product(category_id);
CREATE INDEX IF NOT EXISTS idx_sort ON tb_product(sort);
CREATE INDEX IF NOT EXISTS idx_status ON tb_product(status);
CREATE INDEX IF NOT EXISTS idx_create_time ON tb_product(create_time);

-- 添加注释
COMMENT ON TABLE tb_product IS '商品表';
COMMENT ON COLUMN tb_product.id IS '商品ID';
COMMENT ON COLUMN tb_product.name IS '商品名称';
COMMENT ON COLUMN tb_product.sub_title IS '副标题';
COMMENT ON COLUMN tb_product.description IS '详细描述';
COMMENT ON COLUMN tb_product.category_id IS '分类ID';
COMMENT ON COLUMN tb_product.original_price IS '原价';
COMMENT ON COLUMN tb_product.current_price IS '当前售价';
COMMENT ON COLUMN tb_product.stock IS '总库存';
COMMENT ON COLUMN tb_product.sales IS '累计销量';
COMMENT ON COLUMN tb_product.sort IS '排序权重';
COMMENT ON COLUMN tb_product.status IS '状态（1-上架，2-下架，3-删除）';
COMMENT ON COLUMN tb_product.images IS '主图URL（JSON数组）';
COMMENT ON COLUMN tb_product.gallery IS '轮播图URL（JSON数组）';
COMMENT ON COLUMN tb_product.create_time IS '创建时间';
COMMENT ON COLUMN tb_product.update_time IS '更新时间';
COMMENT ON COLUMN tb_product.product_type IS '商品类型（1-实物，2-虚拟，3-服务）';
COMMENT ON COLUMN tb_product.extra_info IS '扩展信息（JSON格式）';


CREATE TABLE tb_product_dynamic_attr (
                                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                         product_id BIGINT NOT NULL,
                                         attr_name VARCHAR(100) NOT NULL,
                                         attr_value TEXT,
                                         attr_type VARCHAR(20) DEFAULT 'text',
                                         -- 外键约束
                                         CONSTRAINT fk_product_dynamic_attr FOREIGN KEY (product_id) REFERENCES tb_product(id)
);

-- 单独创建索引
CREATE INDEX IF NOT EXISTS idx_product_id ON tb_product_dynamic_attr(product_id);
CREATE INDEX IF NOT EXISTS idx_attr_name ON tb_product_dynamic_attr(attr_name);

-- 添加注释
COMMENT ON TABLE tb_product_dynamic_attr IS '商品动态属性表';
COMMENT ON COLUMN tb_product_dynamic_attr.id IS 'ID';
COMMENT ON COLUMN tb_product_dynamic_attr.product_id IS '商品ID';
COMMENT ON COLUMN tb_product_dynamic_attr.attr_name IS '属性名称';
COMMENT ON COLUMN tb_product_dynamic_attr.attr_value IS '属性值';
COMMENT ON COLUMN tb_product_dynamic_attr.attr_type IS '类型（text/number/json）';

CREATE TABLE tb_product_spec (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 product_id BIGINT NOT NULL,
                                 spec_name VARCHAR(100) NOT NULL,
                                 spec_values TEXT NOT NULL,
                                 price DECIMAL(10, 2) NOT NULL,
                                 stock INT DEFAULT 0,
                                 images TEXT,
                                 -- 外键约束
                                 CONSTRAINT fk_product_spec FOREIGN KEY (product_id) REFERENCES tb_product(id)
);

-- 单独创建索引
CREATE INDEX IF NOT EXISTS idx_product_id ON tb_product_spec(product_id);
CREATE INDEX IF NOT EXISTS idx_spec_values ON tb_product_spec(spec_values);

-- 添加注释
COMMENT ON TABLE tb_product_spec IS '商品规格表';
COMMENT ON COLUMN tb_product_spec.id IS '规格ID';
COMMENT ON COLUMN tb_product_spec.product_id IS '商品ID';
COMMENT ON COLUMN tb_product_spec.spec_name IS '规格名称（如"颜色+尺寸"）';
COMMENT ON COLUMN tb_product_spec.spec_values IS '规格值JSON（如{"颜色":"红色","尺寸":"L"}）';
COMMENT ON COLUMN tb_product_spec.price IS '规格价格';
COMMENT ON COLUMN tb_product_spec.stock IS '规格库存';
COMMENT ON COLUMN tb_product_spec.images IS '规格专属图片（JSON数组）';

CREATE TABLE tb_stock (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          product_id BIGINT NOT NULL,
                          spec_id BIGINT DEFAULT 0,
                          quantity INT DEFAULT 0,
                          frozen_quantity INT DEFAULT 0,
                          version INT DEFAULT 0,
                          update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- 唯一索引（商品+规格组合唯一）
                          UNIQUE (product_id, spec_id),

    -- 外键约束
                          CONSTRAINT fk_stock_product FOREIGN KEY (product_id) REFERENCES tb_product(id),
                          CONSTRAINT fk_stock_spec FOREIGN KEY (spec_id) REFERENCES tb_product_spec(id)
);

-- 添加注释
COMMENT ON TABLE tb_stock IS '库存表';
COMMENT ON COLUMN tb_stock.id IS 'ID';
COMMENT ON COLUMN tb_stock.product_id IS '商品ID';
COMMENT ON COLUMN tb_stock.spec_id IS '规格ID（0表示无规格）';
COMMENT ON COLUMN tb_stock.quantity IS '可用库存';
COMMENT ON COLUMN tb_stock.frozen_quantity IS '冻结库存（订单占用）';
COMMENT ON COLUMN tb_stock.version IS '版本号（乐观锁）';
COMMENT ON COLUMN tb_stock.update_time IS '更新时间';