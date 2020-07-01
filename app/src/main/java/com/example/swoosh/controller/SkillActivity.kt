package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBegginerClick(view: View) {
        advancedSkillBtn.isChecked = false
        player.skill = "Begginer"

    }

    fun onAdvancedClick(view: View) {
        begginerSkillBtn.isChecked = false
        player.skill = "Advanced"

    }

    fun onskillFinishClicked(view: View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)

        } else {
            Toast.makeText(this, "please select a skill level", Toast.LENGTH_SHORT).show()
        }


    }
}
