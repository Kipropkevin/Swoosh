package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBegginerClick(view: View) {
        advancedSkillBtn.isChecked = false
        skill = "Begginer"

    }

    fun onAdvancedClick(view: View) {
        begginerSkillBtn.isChecked = false
        skill = "Advanced"

    }

    fun onskillFinishClicked(view: View) {

        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)

        } else {
            Toast.makeText(this, "please select a skill level", Toast.LENGTH_SHORT).show()
        }


    }
}
