package net.subroh0508.helloworldjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import net.subroh0508.helloworldjetpackcompose.model.IdolModel

class IdolListViewModel : ViewModel() {
    private val _idols: ConflatedBroadcastChannel<List<IdolModel>> by lazy(::ConflatedBroadcastChannel)
    val idols: Flow<List<IdolModel>> get() = _idols.asFlow().apply { launchIn(viewModelScope) }

    fun loadIdols() {
        _idols.offer(
            listOf(
                IdolModel(id = "Asakura_Toru", name = "浅倉透", color = "#50D0D0"),
                IdolModel(id = "Arisugawa_Natsuha", name = "有栖川夏葉", color = "#96E667"),
                IdolModel(id = "Izumi_Mei", name = "和泉愛依", color = "#FF00FF"),
                IdolModel(id = "Ichikawa_Hinana", name = "市川雛菜", color = "#FFC639"),
                IdolModel(id = "Osaki_Amana", name = "大崎甘奈", color = "#F54275"),
                IdolModel(id = "Osaki_Tenka", name = "大崎甜花", color = "#E75BEC"),
                IdolModel(id = "Kazano_Hiori", name = "風野灯織", color = "#144384"),
                IdolModel(id = "Kuwayama_Chiyuki", name = "桑山千雪", color = "#FBFBFB"),
                IdolModel(id = "Komiya_Kaho", name = "小宮果穂", color = "#E75029"),
                IdolModel(id = "Saijo_Juri", name = "西城樹里", color = "#FFCB13"),
                IdolModel(id = "Sakuragi_Mano", name = "櫻木真乃", color = "#FFBAD6"),
                IdolModel(id = "Shirase_Sakuya", name = "白瀬咲耶", color = "#006047"),
                IdolModel(id = "Serizawa_Asahi", name = "芹沢あさひ", color = "#F30100"),
                IdolModel(id = "Sonoda_Chiyoko", name = "園田智代子", color = "#F93B90"),
                IdolModel(id = "Tanaka_Mamimi", name = "田中摩美々", color = "#A846FB"),
                IdolModel(id = "Tsukioka_Kogane", name = "月岡恋鐘", color = "#F94CAD"),
                IdolModel(id = "Hachimiya_Meguru", name = "八宮めぐる", color = "#FFE012"),
                IdolModel(id = "Higuchi_Madoka", name = "樋口円香", color = "#BE1E3E"),
                IdolModel(id = "Hukumaru_Koito", name = "福丸小糸", color = "#7967C3"),
                IdolModel(id = "Mayuzumi_Fuyuko", name = "黛冬優子", color = "#5CE626"),
                IdolModel(id = "Mitsumine_Yuika", name = "三峰結華", color = "#3B91C4"),
                IdolModel(id = "Morino_Rinze", name = "杜野凛世", color = "#84C0EA"),
                IdolModel(id = "Yukoku_Kiriko", name = "幽谷霧子", color = "#D9F2DD"),
            )
        )
    }
}
