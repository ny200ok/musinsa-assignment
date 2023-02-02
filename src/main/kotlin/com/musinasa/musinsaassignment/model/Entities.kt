package com.musinasa.musinsaassignment.model

import javax.persistence.*

/**
 * Created by owen.ny on 2023/02/02.
 */
@Entity
class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,
    var name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: CategoryEntity? = null,
    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var subCategories: List<CategoryEntity> = emptyList(),
)