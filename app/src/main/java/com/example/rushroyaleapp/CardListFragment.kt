package com.example.rushroyaleapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.util.ArrayList


class CardListFragment : Fragment(R.layout.fragment_card_list), Adapter.OnItemClickListener {
    private val cardList = generateCardList(53)
    private val adapter = Adapter(cardList, this)
    lateinit var images: Array<Int>
    var names: Array<String?> = emptyArray()
    var factions: Array<String?> = emptyArray()
    var unitTypes: Array<String?> = emptyArray()
    var targets: Array<String?> = emptyArray()
    var damages: Array<String?> = emptyArray()
    var name = ""
    var faction = ""
    var unitType = ""
    var target = ""
    var damage = ""

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance().reference.child("Cards")
        images = arrayOf(
            R.drawable.archer_icon,
            R.drawable.bombardier_icon,
            R.drawable.cold_mage_icon,
            R.drawable.fire_mage_icon,
            R.drawable.hunter_icon,
            R.drawable.lightning_mage_icon,
            R.drawable.poisoner_icon,
            R.drawable.rogue_icon,
            R.drawable.thrower_icon,
            R.drawable.alchemist_icon,
            R.drawable.banner_icon,
            R.drawable.magic_cauldron_icon,
            R.drawable.chemist_icon,
            R.drawable.grindstone_icon,
            R.drawable.priestess_icon,
            R.drawable.sentry_icon,
            R.drawable.sharpshooter_icon,
            R.drawable.zealot_icon,
            R.drawable.catapult_icon,
            R.drawable.crystalmancer_icon,
            R.drawable.engineer_icon,
            R.drawable.gargoyle_icon,
            R.drawable.executioner_icon,
            R.drawable.mime_icon,
            R.drawable.plague_doctor_icon,
            R.drawable.ivy_icon,
            R.drawable.portal_keeper_icon,
            R.drawable.pyrotechnic_icon,
            R.drawable.reaper_icon,
            R.drawable.portal_keeper_icon,
            R.drawable.thunderer_icon,
            R.drawable.vampire_icon,
            R.drawable.wind_archer_icon,
            R.drawable.boreas_icon,
            R.drawable.corsair_icon,
            R.drawable.cultist_icon,
            R.drawable.demon_hunter_icon,
            R.drawable.demonologist_icon,
            R.drawable.dryad_icon,
            R.drawable.frost_icon,
            R.drawable.harlequin_icon,
            R.drawable.hex_icon,
            R.drawable.knight_statue_icon,
            R.drawable.clock_of_power_icon,
            R.drawable.meteor_icon,
            R.drawable.stasis_icon,
            R.drawable.summoner_icon,
            R.drawable.trapper_icon,
            R.drawable.shaman_icon,
            R.drawable.blade_dancer_icon,
            R.drawable.inquisitor_icon,
            R.drawable.robot_icon,
            R.drawable.scrapper_icon
        )

        for (i in 0..52) {
            database.child(i.toString()).get().addOnSuccessListener {
                name = it.child("Name").value.toString()
                names = append(names, name)
                faction = it.child("Faction").value.toString()
                factions = append(factions, faction)
                unitType = it.child("Unit type").value.toString()
                unitTypes = append(unitTypes, unitType)
                target = it.child("Target").value.toString()
                targets = append(targets, target)
                damage = it.child("Damage").value.toString()
                damages = append(damages, damage)
            }.addOnFailureListener {
                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun append(arr: Array<String?>, element: String): Array<String?> {
        val array = arrayOfNulls<String>(arr.size + 1)
        System.arraycopy(arr, 0, array, 0, arr.size)
        array[arr.size] = element
        return array
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_card_list, container, false)
        val cardListRecyclerView = v.findViewById<RecyclerView>(R.id.CardListRecyclerView)
        cardListRecyclerView.adapter = adapter
        cardListRecyclerView.layoutManager = LinearLayoutManager(activity)
        cardListRecyclerView.setHasFixedSize(true)
        return v

    }

    private fun generateCardList(size: Int): List<Item> {

        val list = ArrayList<Item>()

        for (i in 0 until size) {
            val drawable = when (i % 53) {
                0 -> R.drawable.archer_icon
                1 -> R.drawable.bombardier_icon
                2 -> R.drawable.cold_mage_icon
                3 -> R.drawable.fire_mage_icon
                4 -> R.drawable.hunter_icon
                5 -> R.drawable.lightning_mage_icon
                6 -> R.drawable.poisoner_icon
                7 -> R.drawable.rogue_icon
                8 -> R.drawable.thrower_icon
                9 -> R.drawable.alchemist_icon
                10 -> R.drawable.banner_icon
                11 -> R.drawable.magic_cauldron_icon
                12 -> R.drawable.chemist_icon
                13 -> R.drawable.grindstone_icon
                14 -> R.drawable.priestess_icon
                15 -> R.drawable.sentry_icon
                16 -> R.drawable.sharpshooter_icon
                17 -> R.drawable.zealot_icon
                18 -> R.drawable.catapult_icon
                19 -> R.drawable.crystalmancer_icon
                20 -> R.drawable.engineer_icon
                21 -> R.drawable.gargoyle_icon
                22 -> R.drawable.executioner_icon
                23 -> R.drawable.mime_icon
                24 -> R.drawable.plague_doctor_icon
                25 -> R.drawable.ivy_icon
                26 -> R.drawable.portal_keeper_icon
                27 -> R.drawable.pyrotechnic_icon
                28 -> R.drawable.reaper_icon
                29 -> R.drawable.portal_mage_icon
                30 -> R.drawable.thunderer_icon
                31 -> R.drawable.vampire_icon
                32 -> R.drawable.wind_archer_icon
                33 -> R.drawable.boreas_icon
                34 -> R.drawable.corsair_icon
                35 -> R.drawable.cultist_icon
                36 -> R.drawable.demon_hunter_icon
                37 -> R.drawable.demonologist_icon
                38 -> R.drawable.dryad_icon
                39 -> R.drawable.frost_icon
                40 -> R.drawable.harlequin_icon
                41 -> R.drawable.hex_icon
                42 -> R.drawable.knight_statue_icon
                43 -> R.drawable.clock_of_power_icon
                44 -> R.drawable.meteor_icon
                45 -> R.drawable.stasis_icon
                46 -> R.drawable.summoner_icon
                47 -> R.drawable.trapper_icon
                48 -> R.drawable.shaman_icon
                49 -> R.drawable.blade_dancer_icon
                50 -> R.drawable.inquisitor_icon
                51 -> R.drawable.robot_icon
                else -> R.drawable.scrapper_icon
            }
            val name = when (i % 53) {
                0 -> "Archer"
                1 -> "Bombardier"
                2 -> "Cold Mage"
                3 -> "Fire Mage"
                4 -> "Hunter"
                5 -> "Lightning Mage"
                6 -> "Poisoner"
                7 -> "Rogue"
                8 -> "Thrower"
                9 -> "Alchemist"
                10 -> "Banner"
                11 -> "Magic Cauldron"
                12 -> "Chemist"
                13 -> "Grindstone"
                14 -> "Priestess"
                15 -> "Sentry"
                16 -> "Sharpshooter"
                17 -> "Zealot"
                18 -> "Catapult"
                19 -> "Crystalmancer"
                20 -> "Engineer"
                21 -> "Gargoyle"
                22 -> "Executioner"
                23 -> "Mime"
                24 -> "Plague Doctor"
                25 -> "Ivy"
                26 -> "Portal Keeper"
                27 -> "Pyrotechnic"
                28 -> "Reaper"
                29 -> "Portal Keeper"
                30 -> "Thunderer"
                31 -> "Vampire"
                32 -> "Wind Archer"
                33 -> "Boreas"
                34 -> "Corsair"
                35 -> "Cultist"
                36 -> "Demon Hunter"
                37 -> "Demonologist"
                38 -> "Dryad"
                39 -> "Frost"
                40 -> "Harlequin"
                41 -> "Hex"
                42 -> "Knight Statue"
                43 -> "Clock of Power"
                44 -> "Meteor"
                45 -> "Stasis"
                46 -> "Summoner"
                47 -> "Trapper"
                48 -> "Shaman"
                49 -> "Blade Dancer"
                50 -> "Inquisitor"
                51 -> "Robot"
                else -> "Scrapper"
            }
            val item = Item(drawable, name)
            list += item
        }
        return list


    }

    override fun onItemClick(position: Int) {
        val intent = Intent(requireActivity(), CardAttributes::class.java)
        intent.putExtra("image", images[position])
        intent.putExtra("name", "Name: " + names[position])
        intent.putExtra("faction", "Faction: " + factions[position])
        intent.putExtra("unitType", "Unit Type: " + unitTypes[position])
        intent.putExtra("target", "Target: " + targets[position])
        intent.putExtra("damage", "Damage: " + damages[position])
        startActivity(intent)
    }
}
