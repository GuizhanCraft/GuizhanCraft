package net.guizhanss.guizhancraft.utils.constants

import net.guizhanss.guizhanlib.kt.slimefun.items.builder.MaterialType
import net.guizhanss.guizhanlib.kt.slimefun.items.builder.asMaterialType

enum class HeadTexture(
    val texture: String
) {

    // https://minecraft-heads.com/custom-heads/monsters/4500-poro
    GROUP_MAIN("15561bc0c5fa8e59f0799a24ce1bae7f43f1c4f330b3af8c663943a50623fa9"),

    // https://minecraft-heads.com/custom-heads/decoration/63053-machine-part
    GROUP_MATERIALS("7bf208de0006b40f49063c3d9451bd0086cc69e78796dd0454b78d959c727ecc"),

    // https://minecraft-heads.com/custom-heads/decoration/21563-generator
    GROUP_GENERATORS("7f9f356f5fe7d1bc92cddfaeba3ee773ac9df1cc4d1c2f8fe5f47013032c551d"),

    // https://minecraft-heads.com/custom-heads/decoration/60493-technical-device
    GROUP_MACHINES("4a6938f70e49f5a2ff59e5bdfbbe4236902bd91c3f5baca0101801f2e4a98560"),

    // https://minecraft-heads.com/custom-heads/decoration/4008-hourglass
    RECIPE_FE("6fe7d46322477d61d41c18788f5c1afd24ed526eb3ed84127f212e2515b1883"),

    ;

    val materialType: MaterialType get() = texture.asMaterialType()
}
